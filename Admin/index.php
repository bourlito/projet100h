<?php
  session_start();

  if (!isset($_SESSION['username'])) {
  	$_SESSION['msg'] = "You must log in first";
  	header('location: login.php');
  }

  if (isset($_GET['logout'])) {
  	session_destroy();
  	unset($_SESSION['username']);
  	header("location: login.php");
  }
?>
<!DOCTYPE html>
<html>
<head>
	<title>HEI Oenologie Admin</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="header">
	<h2>Home Page</h2>
</div>
<div class="content">
  	<!-- notification message -->
  	<?php if (isset($_SESSION['success'])) : ?>
      <div class="error success" >
      	<h3>
          <?php
          	echo $_SESSION['success'];
          	unset($_SESSION['success']);
          ?>
      	</h3>
      </div>
  	<?php endif ?>

    <!-- logged in user information -->
    <?php  if (isset($_SESSION['username'])) :

      if (isset($_POST['updateseance'])){

      $seance = $_POST['seance'];
      $libelle = $_POST['libelle'];
      $date = $_POST['date'];
      $infos = $_POST['infos'];
      $db = mysqli_connect('db724410769.db.1and1.com', 'dbo724410769', 'Strasbourg1996*', 'db724410769') or die("Unable to connect to MySQL");

   $query = "UPDATE `seance` SET Libelle='$libelle', Date='$date', Informations='$infos' WHERE Id_seance='$seance'";

   $result = mysqli_query($db, $query);

   if($result)
   {
       echo 'Data Updated';
   }else{
       echo 'Data Not Updated';
   }
   mysqli_close($db);
 }

    if (isset($_POST['updatequestion'])) {

        $question=$_POST['question'];
        $libelle=$_POST['libelle'];
        $db = mysqli_connect('db724410769.db.1and1.com', 'dbo724410769', 'Strasbourg1996*', 'db724410769') or die("Unable to connect to MySQL");
        $query = "UPDATE `question` SET Libelle='$libelle' WHERE Id_question='$question'";
        $result = mysqli_query($db, $query);

        if($result)
        {
            echo 'Data Updated';
        }else{
            echo 'Data Not Updated';
        }
        mysqli_close($db);
       }


  ?>
    	<p>Welcome <strong><?php echo $_SESSION['username']; ?></strong></p>
      <form method="post" action="index.php">
        <div class="header"><h1> Mise à jour des séances</h1></div>
      <div class="input-group" >
          Séance: <select name="seance">
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                </select>
              </div></br>
      <div class="input-group"> <label>  Nom de la séance :</label> <input type="text" name="libelle" required> </br> </div>
      <div class="input-group" > <label> Date : </label><input type="date" name="date" required></br> </div>
      <div class="input-group"> <label> Infos sur la séance :</label> <textarea name="infos" rows="10" cols="88"></textarea></div>
      <div class="input-group">
      <input type="submit" name="updateseance" value="Mettre à jour les séances">
    </div>
      </form>
      <form class="form1" method="post" action="index.php">
        <div class="header"><h1> Mise à jour des questions</h1></div>
        <div class="input-group" >
            Séance: <select name="question">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                  </select>
                </div></br>
        <div class="input-group"> Libelle de la question: <input type="text" name="libelle" required> </br> </div>
        <div class="input-group">
        <input type="submit" name="updatequestion" value="Mettre à jour les séances">
      </div>
      </form>

    	<p> <a href="index.php?logout='1'" style="color: red;">logout</a> </p>
    <?php endif ?>
</div>

</body>
</html>
