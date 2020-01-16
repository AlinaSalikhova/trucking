<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Trucking</title>
    <style>
        label {
            width: 135px;
            display: inline-block;
            text-align: right;
        }

        A{
            color: black;
        }
        a:hover{
            text-decoration:none;
            color : black;
        }
        input {
            width: 250px;
            display: inline-block;
        }

        form {
            display: inline;
        }
    </style>
</head>
<body data-logged-in-user="${username}"
      data-is-admin="${admin?c}">
<div class="container-fluid">
    <nav class="navbar navbar-light bg-light">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="navbar-brand" href="/">Индустрия грузоперевозок</a>
            </li>
            <li class="nav-item">
                <a class="navbar-link" href="/application">Содать заявку</a>
            </li>
        </ul>

        <form class="form-inline">
            <div class="navbar-text"> Привет, ${username} &nbsp;</div>
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit"><a href="/logout">Выйти</a></button>
        </form>
    </nav>

    <div class="container-fluid  mt-3 mb-3">
        <#if admin>
            <button type="button" class="btn btn-light"><a href="/users">Список зарегистрированных пользователей</a></button>
        </#if>
    </div>
    <div class="container-fluid pl-3 pr-3">
        <h2>Заявки</h2>
        <#if admin>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Ползователь</th>
                    <th scope="col">Дата заявки</th>
                    <th scope="col">Вес груза, (кг)</th>
                    <th scope="col">Объем груза, (м3)</th>
                    <th scope="col">Адрес отправления</th>
                    <th scope="col">Адрес доставки</th>
                    <th scope="col">Имя заказчика</th>
                    <th scope="col">Номер телефона</th>
                    <th scope="col">Комментарии</th>
                    <th scope="col">Статус</th>
                    <th scope="col">Управление</th>
                </tr>
                </thead>
                <#list applications as app>
                    <tr>
                        <td>${app.id}</td>
                        <td>${app.owner.username}</td>
                        <td>${app.createdAt}</td>
                        <td>${app.volume}</td>
                        <td>${app.weight}</td>
                        <td>${app.addressFrom}</td>
                        <td>${app.addressTo}</td>
                        <td>${app.userName}</td>
                        <td>${app.phone}</td>
                        <td>${app.comment}</td>
                        <td>${app.status}</td>
                        <td>
                            <form action="/" method="POST">
                                <input type="hidden" name="deleteId" value="${app.id}"/>
                                <input type="hidden" name="updateId"/>
                                <input type="hidden" name="addressFrom"/>
                                <input type="hidden" name="addressTo"/>
                                <input type="hidden" name="volume" value="0.0"/>
                                <input type="hidden" name="weight" value="0.0"/>
                                <input type="hidden" name="phone"/>
                                <input type="hidden" name="userName"/>
                                <input type="hidden" name="comment"/>
                                <button type="submit" class="btn btn-danger">Удалить &nbsp;</button>
                            </form>
                            <form action="/" method="POST">
                                <input type="hidden" name="updateId" value="${app.id}"/>
                                <input type="hidden" name="deleteId"/>
                                <input type="hidden" name="addressFrom"/>
                                <input type="hidden" name="addressTo"/>
                                <input type="hidden" name="volume" value="0.0"/>
                                <input type="hidden" name="weight" value="0.0"/>
                                <input type="hidden" name="phone"/>
                                <input type="hidden" name="userName"/>
                                <input type="hidden" name="comment"/>
                                <button type="submit" class="btn btn-info">Одобрить</button>
                            </form>
                        </td>

                    </tr>
                </#list>
            </table>

        <#else>
            <ul class="list-unstyled">
                <#list applications as app>
                    <#if username = app.owner.username>
                        <li>Заявка от <b>${app.createdAt}</b>: груз <b>${app.volume}</b> м<sup>3</sup>
                            <b>${app.weight}</b> кг по адресу <b>${app.addressFrom}</b>, на адрес
                            <b>${app.addressTo}</b>
                            статус: <b>${app.status}</b>
                        </li>
                    </#if>
                </#list>
            </ul>
        </#if>
        <br>
        <br>


    </div>
    <br><br><br>

</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
