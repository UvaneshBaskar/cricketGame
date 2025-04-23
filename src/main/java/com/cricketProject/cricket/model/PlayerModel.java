package com.cricketProject.cricket.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModel {

    @Id
    private int id;
    private int playerId;
    private String teamId;
    private String playerName;
    private int jerseyNumber;
    private String role;
    private String playerTeam;

}
