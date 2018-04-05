<?php
  session_start();

  if (!isset($_SESSION['username'])) {
  	$_SESSION['message'] = "You must log in first";
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
  <meta charset="UTF-8">
</head>
<body>
  <?php if (isset($_SESSION['message'])): ?>
<div class="msg">
  <?php
    echo $_SESSION['message'];
    unset($_SESSION['message']);
  ?>
</div>
<?php endif ?>

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
      $db = mysqli_connect('localhost', 'root', '', 'db722523693') or die("Unable to connect to MySQL");
      mysqli_set_charset($db,'utf8');
      $query = "UPDATE `seance` SET Libelle='$libelle', Date='$date', Informations='$infos' WHERE Id_seance='$seance'";

   $result = mysqli_query($db, $query);

   if($result)
   {
       $_SESSION['message'] = "Data updated!";
   }else{
       $_SESSION['message'] = "Data not updated!";
   }
   mysqli_close($db);
 }

    if (isset($_POST['updatequestion'])) {

        $libelle=$_POST['libelle'];
        $reponse=$_POST['reponse'];
        $seance=$_POST['seance'];
          $db = mysqli_connect('localhost', 'root', '', 'db722523693') or die("Unable to connect to MySQL");
          mysqli_set_charset($db,'utf8');
          $query1 = "INSERT INTO `question` (`Libelle`) VALUES ('$libelle')";
          $result1 = mysqli_query($db, $query1);
          $query2 = "SELECT `Id_question` FROM `question` WHERE Libelle='$libelle'";
          $result2 = mysqli_query($db, $query2);

          $result22=mysqli_fetch_assoc($result2);
          $id = (int) $result22['Id_question'];

          if($reponse==1){

          $query3="INSERT INTO `correspondre` (`Id_question`, `Id_reponse`) VALUES ('$id', '1');
          INSERT INTO `correspondre` (`Id_question`, `Id_reponse`) VALUES ('$id','4');
          INSERT INTO `poser`(`Id_seance`,`Id_question`) VALUES ('$seance','$id');";
          $result3=mysqli_multi_query($db, $query3);

        }else{
          $query4="INSERT INTO `correspondre` (`Id_question`, `Id_reponse`) VALUES ('$id', '2');
          INSERT INTO `correspondre` (`Id_question`, `Id_reponse`) VALUES ('$id','3');
          INSERT INTO `poser`(`Id_seance`,`Id_question`) VALUES ('$seance','$id');";
          $result4= mysqli_multi_query($db, $query4);

        }

        if($result1 && $result2)
        {
             $_SESSION['message'] = "Data updated!";
        }else{
             $_SESSION['message'] = "Data not updated!";
        }
        mysqli_close($db);
       }

       $db = mysqli_connect('localhost', 'root', '', 'db722523693') or die("Unable to connect to MySQL");
       $querytest="SELECT question.Libelle,poser.Id_seance FROM question INNER JOIN poser ON question.Id_question = poser.Id_question";
       $resulttest = mysqli_query($db,$querytest);

       if (isset($_GET['del'])) {
	        $id = $_GET['del'];
	        $resultdel=mysqli_query($db, "DELETE FROM `question` WHERE Libelle='$id'");
          if($resultdel){
            $_SESSION['message'] = "Question deleted!";
	        header('location: index.php');}
          else{
            $_SESSION['message'] = "Question not deleted!";
          }
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
            Séance: <select name="seance">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                  </select>
                </div></br>
        <div class="input-group"> Libelle de la question: <input type="text" name="libelle" required> </br> </div>
      <div class="input-group"> Réponse: <select name="reponse">
              <option value="1">VRAI</option>
              <option value="0">FAUX</option>
            </select> </div>
            <table>
                            <tr>
                                <th>Seance</th>
                                <th>Libelle</th>
                            </tr>

                            <?php while($row = mysqli_fetch_array($resulttest)):?>
                            <tr>
                                <td><?php echo $row['Id_seance'];?></td>
                                <td><?php echo $row['Libelle'];?></td>
                                <td><a onclick="return confirm('Are you sure ?')" href="?del=<?php echo $row['Libelle']; ?>" class="del_btn">Delete</a></td>
                            </tr>
                            <?php endwhile;?>
                        </table>
      <div class="input-group"> <input type="submit" name="updatequestion" value="Mettre à jour les questions"></div>
      </form>
    	<p> <a href="index.php?logout='1'" style="color: red;">logout</a> </p>
    <?php endif ?>
</div>

</body>
</html>
