import kotlinx.serialization.Serializable
import java.sql.Connection
import java.sql.Statement
import kotlinx.coroutines.*
@Serializable data class User(val username : String, val password : String)
class UserNotFoundException(message: String = "User not found"): Exception(message)
class UserService(private val connection:  Connection){
    companion object {
        private const val CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS users (userName varchar(20) PRIMARY KEY, password Varchar(50))"
        private const val SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE userName = ?"
        private const val INSERT_USER = "INSERT INTO users (userName, password) VALUES (?, ?)"
    } 

    init {
        val statement = connection.createStatement()
        statement.executeUpdate(CREATE_TABLE_USERS)
    }

    suspend fun create(user: User){
        val statement = connection.prepareStatement(INSERT_USER)
        statement.setString(1, user.username)
        statement.setString(2, user.password)
        statement.executeUpdate()
    }   

    suspend fun read(user: User) : User = withContext(Dispatchers.IO){
        val statement = connection.prepareStatement(SELECT_USER_BY_USERNAME)
        statement.setString(1, user.username)
        val resultSet = statement.executeQuery()

        if(resultSet.next() && user.password == resultSet.getString(2)){
            return@withContext user
        }else{
            throw UserNotFoundException()
        }
    }
}