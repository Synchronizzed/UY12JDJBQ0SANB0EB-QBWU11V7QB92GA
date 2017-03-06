package core;

import org.bukkit.entity.Player;

import java.sql.*;


public class Database {
    private static Connection connection;

    public static Connection getConnection(){
        return connection;
    }

    public synchronized static void openConnection(){
        try{
            //connect to the database.
            connection = DriverManager.getConnection("JDBC database+table address","username","password");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //Close connection method, just closes the connection.
    public synchronized static void closeConnection(){
        try{
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public synchronized static boolean playerDataContainsPlayer(Player player){
        try{
            //sql line to inject
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM `Stats` WHERE uuid=?;");
            //replaces the ?
            sql.setString(1, player.getUniqueId().toString());
            //executes the query to see and stores it in a var resultSet
            ResultSet resultSet = sql.executeQuery();
            //if there is something as the result this is true, if there isn't it's false.
            boolean containsPlayer = resultSet.next();

            //close the statement and stop the query(resultSet)
            sql.close();
            resultSet.close();
            //return true or false
            return containsPlayer;

        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static void addSQL(Player target, String section, int amount) {
        openConnection();
        try {
            //Default level is = 1;
            int PrevLevel = 1;

            //only works if player is already on database
            if (playerDataContainsPlayer(target)) {
                //create an sql statement that grabs the level number of the player
                PreparedStatement sql = connection.prepareStatement("SELECT " + section + " FROM `Stats` WHERE uuid=?;");
                sql.setString(1, target.getUniqueId().toString());
                ResultSet result = sql.executeQuery();
                //gets the result
                result.next();

                //gets the level that's on the database to get the last level they were at
                PrevLevel = result.getInt(section);


                //sql statement that actually does beef, updates the level value to the last value it had plus 1(going to the next level)
                PreparedStatement LevelUpdate = connection.prepareStatement("UPDATE `Stats` SET " + section + "=? WHERE uuid=?;");
                LevelUpdate.setInt(1, PrevLevel + amount);
                LevelUpdate.setString(2, target.getUniqueId().toString());
                //run the update
                LevelUpdate.executeUpdate();

                //close everything
                LevelUpdate.close();
                sql.close();
                result.close();

            }
            //this runs if the player is new
            else {
							/*creates a new row with the targets name/uuid as the ?, which is replaced by target.getUniqueId()
							and the level as a default of 1(because everyone starts at level 1) */
                PreparedStatement newPlayer = connection.prepareStatement("INSERT INTO `Stats` values(?,1);");
                newPlayer.setString(1, target.getUniqueId().toString());
                //run the sql statement then close it.
                newPlayer.execute();
                newPlayer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // at the end of everything just simply close the connection, finally, we're done!
            closeConnection();
        }
    }





    public static void subtractSQL(Player target, String section, int amount){
        openConnection();
        try{
            //Default level is = 1;
            int PrevLevel = 1;

            //only works if player is already on database
            if(playerDataContainsPlayer(target)){
                //create an sql statement that grabs the level number of the player
                PreparedStatement sql = connection.prepareStatement("SELECT "+section+" FROM `Stats` WHERE uuid=?;");
                sql.setString(1, target.getUniqueId().toString());
                ResultSet result = sql.executeQuery();
                //gets the result
                result.next();

                //gets the level that's on the database to get the last level they were at
                PrevLevel = result.getInt(section);




                //sql statement that actually does beef, updates the level value to the last value it had plus 1(going to the next level)
                PreparedStatement LevelUpdate = connection.prepareStatement("UPDATE `Stats` SET "+section+"=? WHERE uuid=?;");
                LevelUpdate.setInt(1, PrevLevel - amount);
                LevelUpdate.setString(2, target.getUniqueId().toString());
                //run the update
                LevelUpdate.executeUpdate();

                //close everything
                LevelUpdate.close();
                sql.close();
                result.close();

            }
            //this runs if the player is new
            else{
							/*creates a new row with the targets name/uuid as the ?, which is replaced by target.getUniqueId()
							and the level as a default of 1(because everyone starts at level 1) */
                PreparedStatement newPlayer = connection.prepareStatement("INSERT INTO `Stats` values(?,0);");
                newPlayer.setString(1, target.getUniqueId().toString());
                //run the sql statement then close it.
                newPlayer.execute();
                newPlayer.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // at the end of everything just simply close the connection, finally, we're done!
            closeConnection();
        }
    }



    public static void setSQLInt(Player target, String section, int amount){
        openConnection();
        try{

            //only works if player is already on database
            if(playerDataContainsPlayer(target)){

                //Creates an update statement
                PreparedStatement LevelUpdate = connection.prepareStatement("UPDATE `Stats` SET "+section+"=? WHERE uuid=?;");
                LevelUpdate.setInt(1, amount);
                LevelUpdate.setString(2, target.getUniqueId().toString());
                //run the update
                LevelUpdate.executeUpdate();

                //close everything
                LevelUpdate.close();


            }
            //this runs if the player is new
            else{
                /*creates a new row with the targets name/uuid as the ? and set amount as the other ?, which is replaced by target.getUniqueId()*/
                PreparedStatement newPlayer = connection.prepareStatement("INSERT INTO `Stats` values(?,?);");
                newPlayer.setString(1, target.getUniqueId().toString());
                newPlayer.setInt(2,amount);
                //run the sql statement then close it.
                newPlayer.execute();
                newPlayer.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // at the end of everything just simply close the connection, finally, we're done!
            closeConnection();
        }
    }

    public static void setSQLString (Player target, String section, String string){
        openConnection();
        try{

            //only works if player is already on database
            if(playerDataContainsPlayer(target)){

                //Creates an update statement
                PreparedStatement LevelUpdate = connection.prepareStatement("UPDATE `Stats` SET "+section+"=? WHERE uuid=?;");
                LevelUpdate.setString(1, string);
                LevelUpdate.setString(2, target.getUniqueId().toString());
                //run the update
                LevelUpdate.executeUpdate();

                //close everything
                LevelUpdate.close();


            }
            //this runs if the player is new
            else{
                /*creates a new row with the targets name/uuid as the ? and set amount as the other ?, which is replaced by target.getUniqueId()*/
                PreparedStatement newPlayer = connection.prepareStatement("INSERT INTO `Stats` values(?,?);");
                newPlayer.setString(1, target.getUniqueId().toString());
                newPlayer.setString(2,string);
                //run the sql statement then close it.
                newPlayer.execute();
                newPlayer.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // at the end of everything just simply close the connection, finally, we're done!
            closeConnection();
        }
    }




    //custom SQL getters
    public static int getSQLInt(Player target, String section){
        int resultInt = 0;
        try {
            PreparedStatement sql = connection.prepareStatement("SELECT " + section + " FROM `Stats` WHERE uuid=?;");
            sql.setString(1, target.getUniqueId().toString());
            ResultSet result = sql.executeQuery();
            //gets the result
            result.next();

            //gets the level that's on the database to get the last level they were at
            resultInt = result.getInt(section);
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return resultInt;


    }

    public static String getSQLString(Player target, String section){
        String resultString = "";
        try {
            PreparedStatement sql = connection.prepareStatement("SELECT " + section + " FROM `Stats` WHERE uuid=?;");
            sql.setString(1, target.getUniqueId().toString());
            ResultSet result = sql.executeQuery();
            //gets the result
            result.next();

            //gets the level that's on the database to get the last level they were at
            resultString = result.getString(section);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return resultString;

    }

}
