/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.a9;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Teste {
    
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private static BDVeiculos bd = new BDVeiculos();

    //deixei a variavel static para não ser instanciada e ser a variável que pertence só essa classe
    //com final não pode ser sobrescrito
    private static final String TELA_INICIAL = "TELA_INICIAL";
    private static final String TELA_PASSEIO = "TELA_PASSEIO";
    private static final String TELA_CARGA = "TELA_CARGA";
    private static final String TELA_CADASTRAR_PASSEIO = "TELA_CADASTRAR_PASSEIO";
    private static final String TELA_CONSULTAR_EXCLUIR_PLACA_PASSEIO = "TELA_CONSULTAR_EXCLUIR_PLACA_PASSEIO";
    private static final String TELA_IMPRIMIR_EXCLUIR_TODOS_PASSEIO = "TELA_IMPRIMIR_EXCLUIR_TODOS_PASSEIO";
    private static final String TELA_CADASTRAR_CARGA = "TELA_CADASTRAR_CARGA";
    private static final String TELA_CONSULTAR_EXCLUIR_PLACA_CARGA = "TELA_CONSULTAR_EXCLUIR_PLACA_CARGA";
    private static final String TELA_IMPRIMIR_EXCLUIR_TODOS_CARGA = "TELA_IMPRIMIR_EXCLUIR_TODOS_CARGA";   
    
 public static void main(String[] args) {
        new Teste();
 }
 
 public Teste() {
        //Instanciado o frame e chamado alguns métodos para ele
        frame = new JFrame("Gestão de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        //CardLayout é um gerenciador de layout do Swing que permite empilhar vários painéis (telas) um em cima do outro
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        //Está sendo criado um JPanel (painel principal) usando o CardLayout como gerenciador de layout.

        //Adicionado as telas e seus métodos de criação, e deixado a indentificação pela variavel constante
        mainPanel.add(criarPainelInicial(), TELA_INICIAL);
        mainPanel.add(criarPainelPasseio(), TELA_PASSEIO);
        mainPanel.add(criarPainelCarga(), TELA_CARGA);
        mainPanel.add(criarCadastroPasseio(), TELA_CADASTRAR_PASSEIO);
        mainPanel.add(criarConsultarExcluirPlacaPasseio(), TELA_CONSULTAR_EXCLUIR_PLACA_PASSEIO);
        mainPanel.add(criarImprimirExcluirTodosPasseio(), TELA_IMPRIMIR_EXCLUIR_TODOS_PASSEIO);
        mainPanel.add(criarCadastroCarga(), TELA_CADASTRAR_CARGA);
        mainPanel.add(criarConsultarExcluirPlacaCarga(), TELA_CONSULTAR_EXCLUIR_PLACA_CARGA);
        mainPanel.add(criarImprimirExcluirTodosCarga(), TELA_IMPRIMIR_EXCLUIR_TODOS_CARGA);

        //Adicionado o frame com layout do mainPanel
        frame.add(mainPanel);
        //Inicializado a com a tela TELA_INICIAL
        cardLayout.show(mainPanel, TELA_INICIAL);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
 }
 
 //TELA_INICIAL
 private JPanel criarPainelInicial() {
        
        //Instanciado o JPanel com nome painel e atribuido o titulo
        JPanel painel = new JPanel(new FlowLayout());
        painel.setBorder(BorderFactory.createTitledBorder("Tela Inicial"));
  
        //Instanciando Font para ajustar configuração da fonte
        Font fonteMaior = new Font("Arial", Font.PLAIN, 18);

        //Instanciando JCheckbox Passeio e Carga
        JCheckBox cbPasseio = new JCheckBox("Passeio");
        JCheckBox cbCarga = new JCheckBox("Carga");

        //Adicionando os checkbox
        painel.add(cbPasseio);
        painel.add(cbCarga);
        
        //Adicionando a fonte nos checkbox
        cbPasseio.setFont(fonteMaior);
        cbCarga.setFont(fonteMaior);

        //Criando uma função 
        cbPasseio.addActionListener(e -> {
            //Inicia a próxima tela
            cardLayout.show(mainPanel, TELA_PASSEIO);
            //Após clicar na checkbox, ela é desmarcada automaticamente.
            cbPasseio.setSelected(false);
        });

        cbCarga.addActionListener(e -> {
            //Inicia a próxima tela
            cardLayout.show(mainPanel, TELA_CARGA);
            //Após clicar na checkbox, ela é desmarcada automaticamente.
            cbCarga.setSelected(false);
        });

        //Retorna o painel
        return painel;
    }

    private JPanel criarPainelPasseio() {
        
        //Instanciado o JPanel com nome painel
        JPanel painel = new JPanel(new FlowLayout());
        
        //Atribuindo o layout modo vertical e atribuindo o titulo
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createTitledBorder("Veículos de Passeio"));

        //Instanciando JCheckbox Passeio e Carga
        JCheckBox cb1 = new JCheckBox("Cadastrar");
        JCheckBox cb2 = new JCheckBox("Consultar/Excluir pela placa");
        JCheckBox cb3 = new JCheckBox("Imprimir/Excluir todos");
        
        //Instanciando JButton voltar
        JButton btnVoltar = new JButton("Voltar");
        
        //Instanciando JPanel com botoes para separar os botões
        JPanel botoes = new JPanel();

        painel.add(cb1);
        painel.add(Box.createVerticalStrut(10));
        painel.add(cb2);
        painel.add(Box.createVerticalStrut(10));
        painel.add(cb3);
        painel.add(Box.createVerticalStrut(10));
        botoes.add(btnVoltar);
        botoes.add(criarBotaoSair()); 

        cb1.addActionListener(e -> {
            cardLayout.show(mainPanel, TELA_CADASTRAR_PASSEIO);
            cb1.setSelected(false);
        });

        cb2.addActionListener(e -> {
            cardLayout.show(mainPanel, TELA_CONSULTAR_EXCLUIR_PLACA_PASSEIO);
            cb2.setSelected(false);
        });

        cb3.addActionListener(e -> {
            cardLayout.show(mainPanel, TELA_IMPRIMIR_EXCLUIR_TODOS_PASSEIO);
            cb3.setSelected(false);
        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_INICIAL));
        
        painel.add(botoes);
        return painel;
    }

    private JPanel criarPainelCarga() {
        JPanel painel = new JPanel(new FlowLayout());
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createTitledBorder("Veículos de Carga"));

        JCheckBox cb1 = new JCheckBox("Cadastrar");
        JCheckBox cb2 = new JCheckBox("Consultar/Excluir pela placa");
        JCheckBox cb3 = new JCheckBox("Imprimir/Excluir todos");
        JButton btnVoltar = new JButton("Voltar");
        JPanel botoes = new JPanel();

        painel.add(cb1);
        painel.add(Box.createVerticalStrut(10));
        painel.add(cb2);
        painel.add(Box.createVerticalStrut(10));
        painel.add(cb3);
        painel.add(Box.createVerticalStrut(10));
        botoes.add(btnVoltar);
        botoes.add(criarBotaoSair());  

        cb1.addActionListener(e -> {
            cardLayout.show(mainPanel, TELA_CADASTRAR_CARGA);
            cb1.setSelected(false);
        });

        cb2.addActionListener(e -> {
            cardLayout.show(mainPanel, TELA_CONSULTAR_EXCLUIR_PLACA_CARGA);
            cb2.setSelected(false);
        });

        cb3.addActionListener(e -> {
            cardLayout.show(mainPanel, TELA_IMPRIMIR_EXCLUIR_TODOS_CARGA);
            cb3.setSelected(false);
        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_INICIAL));

        painel.add(botoes);
        return painel;
    }

    private JPanel criarCadastroPasseio() {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Cadastro Passeio"));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JTextField campoPassageiros = new JTextField(20);
        JTextField campoPlaca = new JTextField(20);
        JTextField campoMarca = new JTextField(20);
        JTextField campoModelo = new JTextField(20);
        JTextField campoCor = new JTextField(20);
        JTextField campoQtdRodas = new JTextField(20);
        JTextField campoVelMax = new JTextField(20);
        JTextField campoQtdPistoes = new JTextField(20);
        JTextField campoPotencia = new JTextField(20);

        painel.add(criarLinhaInput("Qtd. de Passageiros:", campoPassageiros));
        painel.add(criarLinhaInput("Placa:", campoPlaca));
        painel.add(criarLinhaInput("Marca:", campoMarca));
        painel.add(criarLinhaInput("Modelo:", campoModelo));
        painel.add(criarLinhaInput("Cor:", campoCor));
        painel.add(criarLinhaInput("Qtd. de Rodas:", campoQtdRodas));
        painel.add(criarLinhaInput("Velocidade Máx.:", campoVelMax));
        painel.add(criarLinhaInput("Qtd. Pistões:", campoQtdPistoes));
        painel.add(criarLinhaInput("Potência:", campoPotencia));

        JPanel botoes = new JPanel();
        JButton btnLimpar = new JButton("Limpar");
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnNovo = new JButton("Novo");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnSair = criarBotaoSair();

        botoes.add(btnCadastrar);
        botoes.add(btnLimpar);
        botoes.add(btnNovo);
        botoes.add(btnVoltar);
        botoes.add(btnSair);

        btnLimpar.addActionListener(e -> {
            campoPassageiros.setText("");
            campoPlaca.setText("");
            campoMarca.setText("");
            campoModelo.setText("");
            campoCor.setText("");
            campoQtdRodas.setText("");
            campoVelMax.setText("");
            campoQtdPistoes.setText("");
            campoPotencia.setText("");
        });
        
        btnCadastrar.addActionListener(e -> {
            try {
                String placaPass = campoPlaca.getText().trim();
                boolean existe = false;
                for (int i = 0; i < bd.getListaPasseio().size(); i++) {
                    if (bd.getListaPasseio().get(i) != null &&
                        bd.getListaPasseio().get(i).getPlaca().equalsIgnoreCase(placaPass)) {
                        throw new VeicExistException(); 
                    }
                }
                if (existe) {
                    throw new VeicExistException();
                }

                Passeio passeio = new Passeio();

                passeio.setQtdPassageiros(Integer.parseInt(campoPassageiros.getText().trim()));
                passeio.setPlaca(placaPass);
                passeio.setMarca(campoMarca.getText().trim());
                passeio.setModelo(campoModelo.getText().trim());
                passeio.setCor(campoCor.getText().trim());
                passeio.setQtdRodas(Integer.parseInt(campoQtdRodas.getText().trim()));

                try {
                    passeio.setVelocMax(Integer.parseInt(campoVelMax.getText().trim()));
                } catch (VelocException ex) {
                    ex.velocException();
                    passeio.setVelocMax(100);
                    JOptionPane.showMessageDialog(null, "Valor inválido para velocidade máxima. Definindo como 100.");
                }

                passeio.getMotor().setQtdPist(Integer.parseInt(campoQtdPistoes.getText().trim()));
                passeio.getMotor().setPotencia(Integer.parseInt(campoPotencia.getText().trim()));

                bd.getListaPasseio().add(passeio);

                JOptionPane.showMessageDialog(painel, "Passeio cadastrado com sucesso!");

                campoPassageiros.setText("");
                campoPlaca.setText("");
                campoMarca.setText("");
                campoModelo.setText("");
                campoCor.setText("");
                campoQtdRodas.setText("");
                campoVelMax.setText("");
                campoQtdPistoes.setText("");
                campoPotencia.setText("");

            } catch (VeicExistException ex) {
                ex.veicExistException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha os campos numéricos corretamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo: " + ex.getMessage());
            } 
        });

        btnNovo.addActionListener(e -> {
            campoPassageiros.setText("");
            campoPlaca.setText("");
            campoMarca.setText("");
            campoModelo.setText("");
            campoCor.setText("");
            campoQtdRodas.setText("");
            campoVelMax.setText("");
            campoQtdPistoes.setText("");
            campoPotencia.setText("");

            campoPassageiros.requestFocus();

        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_PASSEIO));

        painel.add(botoes);
        return painel;
    }

    private JPanel criarConsultarExcluirPlacaPasseio() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createTitledBorder("Consultar/Excluir Placa Passeio"));
        
        JTextField campoPlaca = new JTextField(20);
        JTextField campoPassageiros = new JTextField(20);
        JTextField campoMarca = new JTextField(20);
        JTextField campoModelo = new JTextField(20);
        JTextField campoCor = new JTextField(20);
        JTextField campoQtdRodas = new JTextField(20);
        JTextField campoVelMax = new JTextField(20);
        JTextField campoQtdPistoes = new JTextField(20);
        JTextField campoPotencia = new JTextField(20);
        
        campoPlaca.setBorder(BorderFactory.createLineBorder(Color.RED));
        campoPassageiros.setEditable(false);
        campoMarca.setEditable(false);
        campoModelo.setEditable(false);
        campoCor.setEditable(false);
        campoQtdRodas.setEditable(false);
        campoVelMax.setEditable(false);
        campoQtdPistoes.setEditable(false);
        campoPotencia.setEditable(false);

        painel.add(criarLinhaInput("Placa:", campoPlaca));
        painel.add(criarLinhaInput("Qtd. de Passageiros:", campoPassageiros));
        painel.add(criarLinhaInput("Marca:", campoMarca));
        painel.add(criarLinhaInput("Modelo:", campoModelo));
        painel.add(criarLinhaInput("Cor:", campoCor));
        painel.add(criarLinhaInput("Qtd. de Rodas:", campoQtdRodas));
        painel.add(criarLinhaInput("Velocidade Máx.:", campoVelMax));
        painel.add(criarLinhaInput("Qtd. Pistões:", campoQtdPistoes));
        painel.add(criarLinhaInput("Potência:", campoPotencia));

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnConsultar = new JButton("Consultar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnSair = criarBotaoSair();

        botoes.add(btnConsultar);
        botoes.add(btnExcluir);
        botoes.add(btnVoltar);
        botoes.add(btnSair);
        
        btnConsultar.addActionListener(e -> {
            String placaPass = campoPlaca.getText().trim();

            if (placaPass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe a placa para consulta.");
                return;
            }

            boolean existPlacaPass = false;

            for (int i = 0; i < bd.getListaPasseio().size(); i++) {
                Passeio p = bd.getListaPasseio().get(i);

                if (p != null && p.getPlaca().equalsIgnoreCase(placaPass)) {
                    campoPassageiros.setText(String.valueOf(p.getQtdPassageiros()));
                    campoMarca.setText(p.getMarca());
                    campoModelo.setText(p.getModelo());
                    campoCor.setText(p.getCor());
                    campoQtdRodas.setText(String.valueOf(p.getQtdRodas()));
                    campoVelMax.setText(String.valueOf(p.getVelocMax()));
                    campoQtdPistoes.setText(String.valueOf(p.getMotor().getQtdPist()));
                    campoPotencia.setText(String.valueOf(p.getMotor().getPotencia()));

                    existPlacaPass = true;
                    break;
                }
            }

            if (!existPlacaPass) {
                JOptionPane.showMessageDialog(null, "Não existe veículo de passeio com esta placa.");
                campoPassageiros.setText("");
                campoMarca.setText("");
                campoModelo.setText("");
                campoCor.setText("");
                campoQtdRodas.setText("");
                campoVelMax.setText("");
                campoQtdPistoes.setText("");
                campoPotencia.setText("");
            }
        });
        
        btnExcluir.addActionListener(e -> {
            String placaPasseio = campoPlaca.getText().trim();
            boolean existPlacaPasseio = false;

            if (placaPasseio.isEmpty()) {
                campoPlaca.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "Por favor, informe a placa para exclusão.");
                return;
            }

            for (int i = 0; i < bd.getListaPasseio().size(); i++) {
                if (bd.getListaPasseio().get(i) != null &&
                    bd.getListaPasseio().get(i).getPlaca().equalsIgnoreCase(placaPasseio)) {

                    bd.getListaPasseio().remove(i);
                    existPlacaPasseio = true;
                    JOptionPane.showMessageDialog(null, "Veículo de passeio com placa " + placaPasseio + " excluído com sucesso.");
                    campoPassageiros.setText("");
                    campoPlaca.setText("");
                    campoMarca.setText("");
                    campoModelo.setText("");
                    campoCor.setText("");
                    campoQtdRodas.setText("");
                    campoVelMax.setText("");
                    campoQtdPistoes.setText("");
                    campoPotencia.setText("");
                }
            }

            if (!existPlacaPasseio) {
                campoPlaca.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "Nenhum veículo de passeio encontrado com a placa informada.");
            }
        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_PASSEIO));

        painel.add(botoes);
        return painel;
    }

    private JPanel criarImprimirExcluirTodosPasseio() {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Imprimir/Excluir Todos Passeio"));
        
        String[] colunas = {
            "Placa", "Marca", "Modelo", "Cor", 
            "Qtd. Rodas", "Veloc. Máx.", 
            "Qtd. Pist.", "Potência", "Qtd. Passageiros"
        };

        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabelaPasseios = new JTable(modeloTabela);
        tabelaPasseios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(tabelaPasseios);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        
        JPanel botoes = new JPanel();
        JButton btnImprimir = new JButton("Imprimir Todos");
        JButton btnExcluir = new JButton("Excluir Todos");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnSair = criarBotaoSair();
        
        botoes.add(btnImprimir);
        botoes.add(btnExcluir);
        botoes.add(btnVoltar);
        botoes.add(btnSair);
        
        btnImprimir.addActionListener(e -> {
            modeloTabela.setRowCount(0);

            if (bd.getListaPasseio().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há veículos de passeio cadastrados.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            boolean temVeiculo = false;

            for (int i = 0; i < bd.getListaPasseio().size(); i++) {
                Passeio p = bd.getListaPasseio().get(i);

                if (p != null) {
                    modeloTabela.addRow(new Object[]{
                        p.getPlaca(),
                        p.getMarca(),
                        p.getModelo(),
                        p.getCor(),
                        p.getQtdRodas(),
                        p.getVelocMax(),
                        p.getMotor().getQtdPist(),
                        p.getMotor().getPotencia(),
                        p.getQtdPassageiros()
                    });
                    temVeiculo = true;
                }
            }

            if (!temVeiculo) {
                JOptionPane.showMessageDialog(null, "Sem veículos de passeio para imprimir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnExcluir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza que deseja excluir todos os veículos de passeio?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                bd.getListaPasseio().clear();
                modeloTabela.setRowCount(0);
                JOptionPane.showMessageDialog(
                    null,
                    "Todos os veículos de passeio foram excluídos com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_PASSEIO));

        painel.add(scrollPane);
        painel.add(botoes);
        return painel;
    }

    private JPanel criarCadastroCarga() {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Cadastro Carga"));
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JTextField campoTara = new JTextField(20);
        JTextField campoCargaMax = new JTextField(20);
        JTextField campoPlaca = new JTextField(20);
        JTextField campoMarca = new JTextField(20);
        JTextField campoModelo = new JTextField(20);
        JTextField campoCor = new JTextField(20);
        JTextField campoQtdRodas = new JTextField(20);
        JTextField campoVelMax = new JTextField(20);
        JTextField campoQtdPistoes = new JTextField(20);
        JTextField campoPotencia = new JTextField(20);

        painel.add(criarLinhaInput("Tara:", campoTara));
        painel.add(criarLinhaInput("Carga Máx.:", campoCargaMax));
        painel.add(criarLinhaInput("Placa:", campoPlaca));
        painel.add(criarLinhaInput("Marca:", campoMarca));
        painel.add(criarLinhaInput("Modelo:", campoModelo));
        painel.add(criarLinhaInput("Cor:", campoCor));
        painel.add(criarLinhaInput("Qtd. de Rodas:", campoQtdRodas));
        painel.add(criarLinhaInput("Velocidade Máx.:", campoVelMax));
        painel.add(criarLinhaInput("Qtd. Pistões:", campoQtdPistoes));
        painel.add(criarLinhaInput("Potência:", campoPotencia));

        JPanel botoes = new JPanel();
        JButton btnLimpar = new JButton("Limpar");
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnNovo = new JButton("Novo");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnSair = criarBotaoSair();

        botoes.add(btnCadastrar);
        botoes.add(btnLimpar);
        botoes.add(btnNovo);
        botoes.add(btnVoltar);
        botoes.add(btnSair);

        btnLimpar.addActionListener(e -> {
            campoTara.setText("");
            campoCargaMax.setText("");
            campoPlaca.setText("");
            campoMarca.setText("");
            campoModelo.setText("");
            campoCor.setText("");
            campoQtdRodas.setText("");
            campoVelMax.setText("");
            campoQtdPistoes.setText("");
            campoPotencia.setText("");
        });
        
        btnCadastrar.addActionListener(e -> {
            try {
                Carga carga = new Carga();

                String placaPass = campoPlaca.getText().trim();
                boolean existe = false;
                for (int i = 0; i < bd.getListaCarga().size(); i++) {
                    if (bd.getListaCarga().get(i) != null && 
                        bd.getListaCarga().get(i).getPlaca().equalsIgnoreCase(placaPass)) {
                        existe = true;
                        break;
                    }
                }
                if (existe) {
                    throw new VeicExistException();
                }

                carga.setPlaca(placaPass);
                carga.setMarca(campoMarca.getText().trim());
                carga.setModelo(campoModelo.getText().trim());
                carga.setCor(campoCor.getText().trim());
                carga.setQtdRodas(Integer.parseInt(campoQtdRodas.getText().trim()));
                carga.setTara(Integer.parseInt(campoTara.getText().trim()));
                carga.setCargaMax(Integer.parseInt(campoCargaMax.getText().trim()));

                try {
                    carga.setVelocMax(Integer.parseInt(campoVelMax.getText().trim()));
                } catch (VelocException ex) {
                    ex.velocException();
                    JOptionPane.showMessageDialog(null, "Valor inválido para velocidade máxima. Definindo como 90.");
                    carga.setVelocMax(90);
                }

                carga.getMotor().setQtdPist(Integer.parseInt(campoQtdPistoes.getText().trim()));
                carga.getMotor().setPotencia(Integer.parseInt(campoPotencia.getText().trim()));

                bd.getListaCarga().add(carga);

                JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");

                campoTara.setText("");
                campoCargaMax.setText("");
                campoPlaca.setText("");
                campoMarca.setText("");
                campoModelo.setText("");
                campoCor.setText("");
                campoQtdRodas.setText("");
                campoVelMax.setText("");
                campoQtdPistoes.setText("");
                campoPotencia.setText("");

            } catch (VeicExistException ex) {
                ex.veicExistException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha os campos numéricos corretamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo: " + ex.getMessage());
            } 
        });

        btnNovo.addActionListener(e -> {
            campoTara.setText("");
            campoCargaMax.setText("");
            campoPlaca.setText("");
            campoMarca.setText("");
            campoModelo.setText("");
            campoCor.setText("");
            campoQtdRodas.setText("");
            campoVelMax.setText("");
            campoQtdPistoes.setText("");
            campoPotencia.setText("");

            campoTara.requestFocus();

        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_CARGA));

        painel.add(botoes);
        
        return painel;
    }

    private JPanel criarConsultarExcluirPlacaCarga() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createTitledBorder("Consultar/Excluir Placa Carga"));
        
        JTextField campoPlaca = new JTextField(20);
        JTextField campoTara = new JTextField(20);
        JTextField campoCargaMax = new JTextField(20);
        JTextField campoMarca = new JTextField(20);
        JTextField campoModelo = new JTextField(20);
        JTextField campoCor = new JTextField(20);
        JTextField campoQtdRodas = new JTextField(20);
        JTextField campoVelMax = new JTextField(20);
        JTextField campoQtdPistoes = new JTextField(20);
        JTextField campoPotencia = new JTextField(20);
        
        campoPlaca.setBorder(BorderFactory.createLineBorder(Color.RED));
        campoTara.setEditable(false);
        campoCargaMax.setEditable(false);
        campoMarca.setEditable(false);
        campoModelo.setEditable(false);
        campoCor.setEditable(false);
        campoQtdRodas.setEditable(false);
        campoVelMax.setEditable(false);
        campoQtdPistoes.setEditable(false);
        campoPotencia.setEditable(false);

        painel.add(criarLinhaInput("Placa:", campoPlaca));
        painel.add(criarLinhaInput("Tara:", campoTara));
        painel.add(criarLinhaInput("Carga Máx:", campoCargaMax));
        painel.add(criarLinhaInput("Marca:", campoMarca));
        painel.add(criarLinhaInput("Modelo:", campoModelo));
        painel.add(criarLinhaInput("Cor:", campoCor));
        painel.add(criarLinhaInput("Qtd. de Rodas:", campoQtdRodas));
        painel.add(criarLinhaInput("Velocidade Máx.:", campoVelMax));
        painel.add(criarLinhaInput("Qtd. Pistões:", campoQtdPistoes));
        painel.add(criarLinhaInput("Potência:", campoPotencia));

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnConsultar = new JButton("Consultar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnSair = criarBotaoSair();

        botoes.add(btnConsultar);
        botoes.add(btnExcluir);
        botoes.add(btnVoltar);
        botoes.add(btnSair);
        
        btnConsultar.addActionListener(e -> {
            String placaPass = campoPlaca.getText().trim();

            if (placaPass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe a placa para consulta.");
                return;
            }

            boolean existPlacaPass = false;

            for (int i = 0; i < bd.getListaCarga().size(); i++) {
                Carga p = bd.getListaCarga().get(i);

                if (p != null && p.getPlaca().equalsIgnoreCase(placaPass)) {
                    campoTara.setText(String.valueOf(p.getTara()));
                    campoCargaMax.setText(String.valueOf(p.getCargaMax()));
                    campoMarca.setText(p.getMarca());
                    campoModelo.setText(p.getModelo());
                    campoCor.setText(p.getCor());
                    campoQtdRodas.setText(String.valueOf(p.getQtdRodas()));
                    campoVelMax.setText(String.valueOf(p.getVelocMax()));
                    campoQtdPistoes.setText(String.valueOf(p.getMotor().getQtdPist()));
                    campoPotencia.setText(String.valueOf(p.getMotor().getPotencia()));

                    existPlacaPass = true;
                    break;
                }
            }

            if (!existPlacaPass) {
                JOptionPane.showMessageDialog(null, "Não existe veículo de carga com esta placa.");
                campoTara.setText("");
                campoCargaMax.setText("");
                campoMarca.setText("");
                campoModelo.setText("");
                campoCor.setText("");
                campoQtdRodas.setText("");
                campoVelMax.setText("");
                campoQtdPistoes.setText("");
                campoPotencia.setText("");
            }
        });
        
        btnExcluir.addActionListener(e -> {
            String placaCarga = campoPlaca.getText().trim();
            boolean existPlacaPasseio = false;

            if (placaCarga.isEmpty()) {
                campoPlaca.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "Por favor, informe a placa para exclusão.");
                return;
            }

            for (int i = 0; i < bd.getListaCarga().size(); i++) {
                if (bd.getListaCarga().get(i) != null &&
                    bd.getListaCarga().get(i).getPlaca().equalsIgnoreCase(placaCarga)) {

                    bd.getListaCarga().remove(i);
                    existPlacaPasseio = true;
                    JOptionPane.showMessageDialog(null, "Veículo de carga com placa " + placaCarga + " excluído com sucesso.");
                    campoTara.setText("");
                    campoCargaMax.setText("");
                    campoPlaca.setText("");
                    campoMarca.setText("");
                    campoModelo.setText("");
                    campoCor.setText("");
                    campoQtdRodas.setText("");
                    campoVelMax.setText("");
                    campoQtdPistoes.setText("");
                    campoPotencia.setText("");
                }
            }

            if (!existPlacaPasseio) {
                campoPlaca.setBorder(BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "Nenhum veículo de carga encontrado com a placa informada.");
            }
        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_CARGA));
        
        painel.add(botoes);
        return painel;
    }

    private JPanel criarImprimirExcluirTodosCarga() {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Imprimir/Excluir Todos Carga"));
        
        String[] colunas = {
            "Placa", "Marca", "Modelo", "Cor", 
            "Qtd. Rodas", "Veloc. Máx.", 
            "Qtd. Pist.", "Potência", "Tara", "Carga Máx."
        };

        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabelaCarga = new JTable(modeloTabela);
        tabelaCarga.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(tabelaCarga);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        
        JPanel botoes = new JPanel();
        JButton btnImprimir = new JButton("Imprimir Todos");
        JButton btnExcluir = new JButton("Excluir Todos");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnSair = criarBotaoSair();
        
        botoes.add(btnImprimir);
        botoes.add(btnExcluir);
        botoes.add(btnVoltar);
        botoes.add(btnSair);
        
        btnImprimir.addActionListener(e -> {
            modeloTabela.setRowCount(0);

            if (bd.getListaCarga().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há veículos de carga cadastrados.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            boolean temVeiculo = false;

            for (int i = 0; i < bd.getListaCarga().size(); i++) {
                Carga p = bd.getListaCarga().get(i);

                if (p != null) {
                    modeloTabela.addRow(new Object[]{
                        p.getPlaca(),
                        p.getMarca(),
                        p.getModelo(),
                        p.getCor(),
                        p.getQtdRodas(),
                        p.getVelocMax(),
                        p.getMotor().getQtdPist(),
                        p.getMotor().getPotencia(),
                        p.getTara(),
                        p.getCargaMax()
                    });
                    temVeiculo = true;
                }
            }

            if (!temVeiculo) {
                JOptionPane.showMessageDialog(null, "Sem veículos de carga para imprimir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnExcluir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza que deseja excluir todos os veículos de carga?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                bd.getListaCarga().clear();
                modeloTabela.setRowCount(0);
                JOptionPane.showMessageDialog(
                    null,
                    "Todos os veículos de carga foram excluídos com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, TELA_CARGA));

        painel.add(scrollPane);
        painel.add(botoes);
        
        return painel;
    }

    private JButton criarBotaoSair() {
        JButton btnSair = new JButton("Sair");

        btnSair.addActionListener(e -> {
            int confirmacao = JOptionPane.showConfirmDialog(frame, 
                "Tem certeza que deseja sair?", 
                "Confirmação", 
                JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        return btnSair;
    }

    private JPanel criarLinhaInput(String rotulo, JTextField campo) {
        JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lbl = new JLabel(rotulo);
        lbl.setPreferredSize(new Dimension(150, 25));

        linha.add(lbl);
        linha.add(campo);

        return linha;
    }
    
}
