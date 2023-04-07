/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.da.velha;

/**
 *
 * @author julli
 */
import java.util.Scanner;
public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada = 1, vez = 1;
    private Jogador jogador1;
    private Jogador jogador2;
    private Scanner dados = new Scanner(System.in);

    public Jogo() {
        tabuleiro = new Tabuleiro();
        iniciarJog();
        
        while(Jogar());
    }
    
    public void iniciarJog(){
        System.out.println("Quem será o Jogador 1?");
        if(escolherJog() == 1)
            this.jogador1 = new Humano(1);
        else
            this.jogador1 = new Computador(1);
        System.out.println("----------------------");
        System.out.println("Quem será o Jogador 2?");
        if(escolherJog() == 1)
            this.jogador2 = new Humano(2);
        else
            this.jogador2 = new Computador(2);
    }
    
    public int escolherJog(){
        int op = 0;
        do{
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            op = dados.nextInt();
            
            if(op != 1 && op != 2)
                System.out.println("Opção inválida! Tente novamente");
        } while (op != 1 && op != 2);
        return op;
    }
    
    public boolean Jogar(){
        if(ganhou() == 0){
            System.out.println("----------------");
            System.out.println("\nRodada " + rodada);
            System.out.println("É a vez do jogador " + vez());
            
            if(vez() == 1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);
            
            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro completo. Jogo empatado.");
                return false;
            }
            
            vez++;
            rodada++;
            return true;
        } else{
            if(ganhou() == -1)
                System.out.println("Parabéns! Jogador 1 ganhou!");
            else
                System.out.println("Parabéns! Jogador 2 ganhou!");
            return false;
        }
    }
    
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){
        if(tabuleiro.checaLinha() == 1)
            return 1;
        if(tabuleiro.checaColuna() == 1)
            return 1;
        if(tabuleiro.checaDiagonal() == 1)
            return 1;
        
        if(tabuleiro.checaLinha() == -1)
            return -1;
        if(tabuleiro.checaColuna() == -1)
            return -1;
        if(tabuleiro.checaDiagonal() == -1)
            return -1;
        return 0;
    }
}
