package com.cricketProject.cricket.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class TeamModel {

    @Id
    private int id;
    private int teamId;
    private String teamName;
    private String home;
    private List<String> playersInTeam ;
}
