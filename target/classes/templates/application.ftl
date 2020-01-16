<c.page>
    <h2>Подать заявку</h2>
    <form method="POST">
        <input type="hidden" name="deleteId"/>
        <input type="hidden" name="updateId"/>
        <h4>Данные о грузе</h4>
        <label>Объем (м<sup>3</sup>):</label>
        <input type="text" name="volume" placeholder="146.6" required pattern="\d+\.?\d+"/>
        <br>
        <label>Вес (кг):</label>
        <input type="text" name="weight" placeholder="146.6" required pattern="\d+\.?\d+"/>
        <br>
        <h4>Направление</h4>
        <label>Пункт А:</label>
        <input type="text" name="addressFrom" placeholder="Россия, Пермь, ул. 25 октября 12" required/>
        <br>
        <br>
        <label>Пункт Б:</label>
        <input type="text" name="addressTo" placeholder="Россия, Пермь, ул. 25 октября 12" required/>
        <br>
        <h4>Контактные данные</h4>
        <label>Ваше имя:</label>
        <input type="text" name="userName" placeholder="Иван" required/>
        <br>
        <br>
        <label>Номер телефона:</label>
        <input type="text" name="phone" placeholder="89991234567" required/>
        <label>Комментарий:</label>
        <input type="text" name="comment" placeholder="Ваш комментарий" required/>
        <br>
        <br>
        <button type="submit" class="btn btn-success" data-toggle="tooltip" data-placement="right"
                title="После отправки заявки менеджер перезвонит вам в течении 10 минут">
            Отправить заявку
        </button>

    </form>
</c.page>