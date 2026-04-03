package DAO;

import DB.DbConnection;
import Model.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
// CRUD of Participant
//
//        // 1- add participant
        public List<Participant> addParticipant(Participant p) throws SQLException {
            try {
                String query ="insert into Participant (participantId, participantName, contactInformation)  Values (?,?,?)";

                Connection myconnection = DbConnection.getConnection();
                if(myconnection !=null)
                {
                    try {
                        PreparedStatement statement = myconnection.prepareStatement(query);
                        //something to get participantId
                        //something to get participantName
                        //something to get contractInformation

                        //***** I think this is wrong.
                        ResultSet eventResults = statement.executeQuery(query);
                        List<Participant> allParticipants = new ArrayList<>();

                        while(eventResults.next())
                        {
                            int id = eventResults.getInt("participantId");
                            String name = eventResults.getString("participantName");
                            String contact = eventResults.getString("contactInformation");


                            Participant participant1 = new Participant(0, null, null, 0, null, id, name, contact); // this needed to be changed because of the way our Participant class works.
                            // these act as placeholders because the DAO is not fetching the event data yet.
                            allParticipants.add(participant1);
                        }
                        return allParticipants;
                    }
                    catch(Exception e)
                    {

                    }

                }

            }
            catch (Exception e )
            {
                e.printStackTrace();
            }
            return null;
        }
}
