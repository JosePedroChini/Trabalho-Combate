/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetocombate;

/**
 *
 * @author José Pedro
 */

    import java.util.Scanner;

class Champion {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    public Champion(String nome, int vida, int ataque, int armadura) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public void takeDamage(Champion other) {
        int danoRecebido = Math.max(1, other.ataque - this.armadura); 
        this.vida = Math.max(0, this.vida - danoRecebido); 
    }

    public String status() {
        if (this.vida == 0) {
            return this.nome + " Morreu";
        }
        return this.nome + " - Vida: " + this.vida;
    }

    public boolean isAlive() {
        return this.vida > 0;
    }
}

public class CombateJogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // PRIMEIRO CAMPEAO
        System.out.print("==================================================\n");
        
        System.out.print("DADOS DO PRIMEIRO CAMPEAO:\n\n");
        System.out.println("Digite o NOME do PRIMEIRO campeao:");
        String nome1 = scanner.nextLine();
        System.out.println("Digite a VIDA INICIAL do PRIMEIRO campeao:");
        int vida1 = scanner.nextInt();
        System.out.println("Digite o ATAQUE do PRIMEIRO campeao:");
        int ataque1 = scanner.nextInt();
        System.out.println("Digite a ARMADURA do PRIMEIRO campeao:");
        int armadura1 = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("==================================================\n");
        
        // SEGUNDO CAMPEAO
        System.out.print("DADOS DO SEGUNDO CAMPEAO:\n\n");
        System.out.println("Digite o NOME do SEGUNDO campeao:");
        String nome2 = scanner.nextLine();
        System.out.println("Digite a VIDA INICIAL do SEGUNDO campeao:");
        int vida2 = scanner.nextInt();
        System.out.println("Digite o ATAQUE do SEGUNDO campeao:");
        int ataque2 = scanner.nextInt();
        System.out.println("Digite a ARMADURA do SEGUNDO campeao:");
        int armadura2 = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("==================================================\n");

        Champion champion1 = new Champion(nome1, vida1, ataque1, armadura1);
        Champion champion2 = new Champion(nome2, vida2, ataque2, armadura2);

        System.out.println("Digite o numero de turnos de combate:");
        int turnos = scanner.nextInt();

        System.out.print("==================================================\n");
        
        boolean combateTerminado = false;
        
        for (int i = 1; i <= turnos; i++) {
            System.out.println("Resultado do Turno " + i + ":");
            
            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);

            System.out.println(champion1.status());
            System.out.println(champion2.status());
            
            System.out.print("==================================================\n");

            if (!champion1.isAlive() || !champion2.isAlive()) {
                combateTerminado = true;
                break;
            }
        }
       
        System.out.println("FIM DO COMBATE!");
        
        scanner.close();
    }
}

