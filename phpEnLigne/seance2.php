<?php
$db_name="db722523693";
$mysql_user="dbo722523693";
$mysql_pass="strasbourg";
$server_name="db722523693.db.1and1.com";

$con=mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name) or die ("Error".mysqli_error($connection));

$sql="SELECT * FROM seance WHERE Id_seance = 2";

$result = mysqli_query($con,$sql);
if (!$result) {
    printf("Error: %s\n", mysqli_error($con));
    exit();
}

$response=array();

 while($row = mysqli_fetch_array($result))
	{
		array_push($response,array('Id-seance' =>$row[0],'libelle'=>$row[1],'Date'=>$row[2],'Infos'=>$row[3],
    'code quizz'=>$row[4]));
	}


echo json_encode(array("server_response"=>$response));

mysqli_close($con);

?>