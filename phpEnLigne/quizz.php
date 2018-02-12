<?php  
header('Content-type: text/html; charset=utf-8');
$username="dbo722523693";  
$password="strasbourg";  
$hostname = "db722523693.db.1and1.com";
$database = "db722523693";  
$sql = "SELECT correspondre.Id_question, question.Libelle_question, reponse.Libelle_reponse, reponse.Correct, seance.Code_quizz FROM question INNER JOIN correspondre ON question.Id_question = correspondre.Id_question INNER JOIN reponse ON correspondre.Id_reponse = reponse.Id_reponse INNER JOIN poser ON question.Id_question = poser.Id_question INNER JOIN seance ON seance.Id_seance = poser.Id_seance ORDER BY correspondre.Id_question";
//connection string with database  
$dbhandle = mysqli_connect($hostname, $username, $password, $database)  
or die("Unable to connect to MySQL");   

mysqli_set_charset($dbhandle,'utf8mb4');
$result = mysqli_query($dbhandle,$sql);  
$json_response = array();
$reponses = array();
// fetch data in array format  
while ($row = $result->fetch_assoc()) {  
	if (!isset($json_response[ $row['Id_question'] ])){
		$json_response[ $row['Id_question'] ] = [
			'Id_question' => $row['Id_question'],
			'Libelle_question' => $row['Libelle_question'],
			'Code_quizz' => $row['Code_quizz'],
			'Reponses' => [
				//'Libelle_reponse' => $row['Libelle_reponse'],
				//'Correct' => $row['Correct']
			],
		];
	}
	$json_response[ $row['Id_question'] ]['Reponses'][] = [
		'Libelle_reponse' => $row['Libelle_reponse'],
		'Correct' => $row['Correct']
	];
}  
$data = [];
foreach ($json_response as $element) {
	$data[] = $element;
}
//  
echo json_encode(array("server_response"=>$data)); 
mysqli_close($dbhandle); 
?>