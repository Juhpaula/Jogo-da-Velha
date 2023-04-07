/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.da.velha;

/**
 *
 * @author julli
 */
public abstract class Jogador {
    protected int[] tentativa = new int[2];
    protected int jogador;
    
    public Jogador(int jogador){
        this.jogador = jogador;
    }
    
    public abstract void jogar(Tabuleiro tabuleiro);
    public abstract void Tentativa(Tabuleiro tabuleiro);
    
    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
    }
}
