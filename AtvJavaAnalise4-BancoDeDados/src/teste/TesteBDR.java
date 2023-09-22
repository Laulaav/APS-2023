package teste;

import java.sql.*;
import java.util.Scanner;

public class TesteBDR {

    public static void main(String[] args) {
        try {
            Connection conn = Conexao.abrir();
            Statement s = conn.createStatement();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Bem vind@s ao banco Laulaav!\n" +
                        "1- Cadastrar Conta\n" +
                        "2- Consultar Conta\n" +
                        "3- Alterar Conta\n" +
                        "4- Remover Conta\n" +
                        "5- Exibir todas as contas\n" +
                        "6- Sair do sistema\n" +
                        "Sua opção:");

                int menu = scanner.nextInt();
                scanner.nextLine(); // Consuma a quebra de linha

                if (menu == 1) {
                    System.out.print("Digite o código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite a idade: ");
                    int idade = scanner.nextInt();

                    System.out.print("Digite o saldo: ");
                    int saldo = scanner.nextInt();

                    String sql = "INSERT INTO Conta (codigo, nome, cpf, idade, saldo) VALUES (?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setInt(1, codigo);
                        preparedStatement.setString(2, nome);
                        preparedStatement.setString(3, cpf);
                        preparedStatement.setInt(4, idade);
                        preparedStatement.setInt(5, saldo);

                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Conta cadastrada com sucesso!");
                        } else {
                            System.out.println("Erro ao cadastrar a conta.");
                        }
                    }
                }else if(menu == 2) {
                	System.out.println("Digite o código da conta: ");
                	int codigo = scanner.nextInt();
                	String sql = "SELECT codigo, nome, cpf, idade, saldo FROM CONTA WHERE codigo = ?";
                	
                	try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                		preparedStatement.setInt(1, codigo);
                        
                        ResultSet rs = preparedStatement.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("Código: " + rs.getInt("codigo")+
                                               "\nNome do cliente: " + rs.getString("nome")+
                                               "\nCpf: " + rs.getString("cpf")+
                                               "\nIdade: " + rs.getInt("idade")+
                                               "\nSaldo: " + rs.getDouble("saldo"));
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    }
                }else if(menu == 3) {
                	
                	System.out.print("Digite o código da conta que deseja alterar: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o novo nome do cliente: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo CPF: ");
                    String novoCpf = scanner.nextLine();

                    System.out.print("Digite a nova idade: ");
                    int novaIdade = scanner.nextInt();

                    System.out.print("Digite o novo saldo: ");
                    double novoSaldo = scanner.nextDouble();

                    String sql = "UPDATE CONTA SET nome = ?, cpf = ?, idade = ?, saldo = ? WHERE codigo = ?";
                    
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setString(1, novoNome);
                        preparedStatement.setString(2, novoCpf);
                        preparedStatement.setInt(3, novaIdade);
                        preparedStatement.setDouble(4, novoSaldo);
                        preparedStatement.setInt(5, codigo);
                        
                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Conta alterada com sucesso!");
                        } else {
                            System.out.println("Erro ao alterar a conta.");
                        }
                    }
                }else if(menu == 4){
                	System.out.print("Digite o código da conta que você quer remover: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    
                    String sql = "DELETE FROM CONTA WHERE codigo = ?";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setInt(1, codigo);
                        
                        int rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Conta removida com sucesso!");
                        } else {
                            System.out.println("Erro ao remover a conta.");
                        }
                    }
                }else if(menu == 5) {
                	String sql = "SELECT * FROM Conta";
                	try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                		 ResultSet rs = preparedStatement.executeQuery();
                         
                         while (rs.next()) {
                             System.out.println("Código: " + rs.getInt("codigo")+
                                                "\nNome do cliente: " + rs.getString("nome")+
                                                "\nCpf: " + rs.getString("cpf")+
                                                "\nIdade: " + rs.getInt("idade")+
                                                "\nSaldo: " + rs.getDouble("saldo"));
                         }
                	}
                }else if(menu == 6) {
                	System.out.println("Saindo do sistema...");
                    conn.close();
                }else {
                	System.out.println("Opção inválida! Tente novamente");
                }
                	 
                }
                // Outros casos do menu podem ser adicionados aqui
            
        } catch (Exception e) {
            System.out.println("Hi, deu bronca...");
            e.printStackTrace();
        }
    }
}
    