<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>AngelPrime to-do List</title>
        <link rel="stylesheet" type="text/css" href="style/lib/Bootstrap/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="style/lib/jQuery/jquery.ui.min.css" />
        <link rel="stylesheet" type="text/css" href="style/assets/todo.css" />
      
	</head>
	
	<body style = "	background-color: #3385FF;
					height: 100%;">
		<header style = "background-color: blue;
							color: white;
							text-algin: center;
							width: 100%;
							height: 50px;
							border-radius: 10px;">
			<center><h3>Trello</h3></center>
		</header>
		<div id = "container">
	
			<div class="task-list task-container" id="pending">
				<h3>Plan</h3>

			</div>
			
			<div class="task-list task-container" id="completed">
				<h3>Done</h3>

			</div>

			
			<div class="task-list">
				<h3>Add a task</h3>
				<form id="todo-form">
					<input type="text" placeholder="Title" />
					<textarea placeholder="Descrtipion"></textarea>
					<input type="text" placeholder="Due Date (dd/mm/yyyy)" />
					<input type="button" class="btn btn-primary" value="Add Task"  onclick="todo.add();"/>
				</form>

				<input type="button" class="btn btn-primary" value="Clear Data" onclick="todo.clear();"/>

				<div id="delete-div">
					Drop Here to Delete
				</div>
			</div>
			
			<div style="clear:both;"></div>
			

			<script type="text/javascript" src="style/lib/jQuery/jquery.min.js"></script>
			<script type="text/javascript" src="style/lib/Bootstrap/bootstrap.min.js"></script>
			<script type="text/javascript" src="style/lib/jQuery/jquery.ui.min.js"></script>
			<script type="text/javascript" src="style/assets/todo.js"></script>
			

			<script type="text/javascript">
				$( "#datepicker" ).datepicker();
				$( "#datepicker" ).datepicker("option", "dateFormat", "dd/mm/yy");

				$(".task-container").droppable();
				$(".todo-task").draggable({ revert: "valid", revertDuration:200 });
				todo.init();
			</script>
		</div>

	
	</body>

</html>