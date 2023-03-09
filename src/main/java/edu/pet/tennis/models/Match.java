package edu.pet.tennis.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Player player1;
    @ManyToOne
    private Player player2;
    @ManyToOne
    private Player winner;

    @Transient
    private Score score = new Score();

    public void setPlayer1(Player player1) {
        this.player1 = player1;
        score.initializationPlayersAndScore();
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
        score.initializationPlayersAndScore();
    }
}
