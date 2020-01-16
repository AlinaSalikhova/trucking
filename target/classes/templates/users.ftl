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
  </head>
  <body data-logged-in-user="${username}">
  <div class="container-fluid">
      <nav class="navbar navbar-light bg-light">
          <a class="navbar-brand" href="/">Индустрия грузоперевозок</a>
          <form class="form-inline">
              <div class="navbar-text"> Привет, ${username} &nbsp;</div>
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit" ><a href="/logout">Выйти</a></button>
          </form>
      </nav>

      <br><br>
    <h2>Список пользователей</h2>
      <br>
      <table class="table table-hover">
          <thead>
          <tr>
              <th scope="col">Login</th>
              <th scope="col">Status</th>
          </tr>
          </thead>
      <#list users as user>
          <tr>
              <td>${user.username}</td>
              <td>(${user.enabled?then("<font color=\"green\">активен</font>", "<font color=\"red\">неактивен</font>")})</td>
          </tr>
      </#list>

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
