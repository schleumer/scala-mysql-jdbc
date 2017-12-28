package example

import java.sql.DriverManager

// Dá uma lida no build.sbt primeiro

object Main extends App {
  // Isso é só pra carregar o driver de conexão do MySQL e tornar ele visível pro JDBC
  val driver = new com.mysql.jdbc.Driver

  // Host do banco
  val host = "localhost"
  // Database
  val dbname = "test"
  // Usuário
  val username = "root"
  // Senha
  val password = ""

  // -----------------------------------,   esse `s` indica que o compilador irá processar
  //                                    \/  os valores que possuem $ como variável, se chama interpolação ou interpolation
  val connection = DriverManager.getConnection(s"jdbc:mysql://$host/$dbname?user=$username&password=$password")

  // Cria um statement no JDBC, statement seria um contexto para execução de query
  val statement = connection.createStatement()

  // Aqui você executa uma query, o JDBC cria um result set, ou "vetor de resultados"
  val resultSet = statement.executeQuery("SELECT 1 as result")

  // enquanto existir resultado para consumir
  while (resultSet.next()) {
    // pega a coluna result como Int
    val result = resultSet.getInt("result")

    // faz um print do valor
    println(result)
  }

  // fecha os recursos de result e statement
  resultSet.close()
  statement.close()
}
