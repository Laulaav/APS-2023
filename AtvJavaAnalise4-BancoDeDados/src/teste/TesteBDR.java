package teste;


import java.sql.*;
import java.util.Scanner;



public class TesteBDR {


    public static void main(String[] args) {
        try  {  
            System.out.println("0");
            Connection conn = Conexao.abrir();
            System.out.println("1");
            
            Statement s = conn.createStatement();
            System.out.println("2");
            
            ResultSet rs = s.executeQuery("SELECT codigo, nome, cpf, idade, saldo FROM CONTA");
            System.out.println("3");
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Bem vind@s ao banco Laulaav!\n"+
                               "1- Cadastrar Conta\n"+
            		           "2- Consultar Conta\n"+
                               "3- Alterar Conta\n"+
            		           "4- Remover Conta\n"+
                               "5- Exibir todas as contas\n"+
            		           "6- Sair do sistema\n"+
                               "Sua opção:");
            int menu = scanner.nextInt();
            
            
        
            while (rs.next()) {
                System.out.println("Código: " + rs.getInt("codigo") + "\nNome do cliente: "+ rs.getString("nome") + "\nCpf: " + rs.getString("cpf") + "\nIdade: " + rs.getInt("idade") + "\nSaldo: "+  rs.getDouble("saldo") + "\n");
            }
            rs.close();
            s.close();
            conn.close();
            }  catch(Exception e)  {  
                System.out.println("Hi, deu bronca...");  
            }   
        }
    }
