$(document).ready(() => {

    fetch('http://localhost:6789/ShoppingHalloween_war_exploded/MyOrder')
        .then(res => {
            return res.json()
        }).then(data => {
            const object = JSON.parse(data)
            $('#product').html(loadData(object))
        })

    const statusMess = {
        'one': 'Chờ',
        'two': 'Liên hệ người bán',
        'three': 'Hủy đơn hàng'
    }

    function loadData(object)
    {
        let html = ``
        let check = true
        for (const key in object) {
            if (object[key] instanceof Array) {
                let sum = 0
                for (let i = 0; i < object[key].length; ++i) {
                    check = false
                    html += `
                                <div class="product-item">
                                    <img src="${object[key][i].urlImage}" alt="">
                                    <div class="product-detail">
                                        <p>${object[key][i].productName}</p>
                                        <span>x${object[key][i].quantity}</span>
                                    </div>
                                    <p class="price">${object[key][i].quantity * object[key][i].price}.0</p>                   
                                </div>
                            `
                    sum += object[key][i].quantity * object[key][i].price
                }
                html += `
                            <div class="pay">
                                <span><img src="icons/gross.png" alt=""><a href=""></a>Tổng số tiền: <span>$ </span><span>${sum}</span></span>
                                <div class="pay-function">
                                    <a href="">${statusMess['one']}</a>
                                    <a href="">${statusMess['two']}</a>
                                    <a href="">${statusMess['three']}</a>
                                </div>
                            </div>
                        `
            }
        }
        if(check)
        {
            html += `
                       <div style="height: 435px;display: flex;align-items: center;justify-content: center">
                           <img style="width: 100px;height: 100px;background-position: center;background-size: cover" src="https://deo.shopeemobile.com/shopee/shopee-pcmall-live-sg/assets/5fafbb923393b712b96488590b8f781f.png" alt="">
                       </div>
                   `;
        }
        return html
    }
    const li = $('.main-right ul li');
    for (let i = 0; i < li.length; ++i) {
        $(li[i]).on('click', async (e) => {
            e.preventDefault();
            for (let j = 0; j < li.length; ++j) {
                $(li[j]).css({
                    'border-bottom': 'none'
                })
            }
            $(li[i]).css({
                'border-bottom': '2px solid red',
            })
            const status = i < 4 ? 1 : i !== 4 ? 3 : 2;
            if (status === 2) {

            } else if (status === 3) {
                statusMess['one'] = 'Mua lại'
                statusMess['three'] = 'Chi tiết đơn hủy'
            }
            const data = {'status': status}
            const res = await fetch('http://localhost:6789/ShoppingHalloween_war_exploded/MyOrder', {
                method: 'post',
                body: JSON.stringify(data),
            })
            const value = await res.json()
            const object = JSON.parse(value)
            $('#product').html(loadData(object))
        })
    }
})

