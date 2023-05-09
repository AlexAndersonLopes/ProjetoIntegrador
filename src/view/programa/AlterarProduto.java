package view.programa;

import dao.ProdutoDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;

public class AlterarProduto extends javax.swing.JFrame {

    
    public AlterarProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/fundo.png"));
            Image image = icon.getImage();
            public void paintComponent(Graphics g){
                super.paintComponent(g); // Chama o método paintComponent da superclasse
                g.drawImage(image, 0,0, getWidth(), getHeight(),this);
            }
        };
        barraAlterar = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel(){

        };
        jLabel9 = new javax.swing.JLabel();
        txtCodigoBarras = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        txtProduto = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        quantidadeTotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAcrescentar = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        btPesquisarPorNome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jTextField5.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        barraAlterar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Codigo de Barras: ");

        txtCodigoBarras.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btPesquisar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/procurar.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        txtProduto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtMarca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtPreco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Quantidade:");

        quantidadeTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Acrescentar + ");

        txtAcrescentar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btVoltar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setMaximumSize(new java.awt.Dimension(132, 50));
        btVoltar.setMinimumSize(new java.awt.Dimension(132, 50));
        btVoltar.setPreferredSize(new java.awt.Dimension(132, 50));
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btAtualizar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atualizar.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setMaximumSize(new java.awt.Dimension(132, 50));
        btAtualizar.setMinimumSize(new java.awt.Dimension(132, 50));
        btAtualizar.setPreferredSize(new java.awt.Dimension(132, 50));
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Produto:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Preço:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(quantidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAcrescentar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btPesquisar)
                        .addGap(291, 291, 291))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtAcrescentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        barraAlterar.addTab("Alterar Produtos     ", jPanel3);

        jPanel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tabela.setBackground(new java.awt.Color(255, 255, 255));
        tabela.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tabela.setForeground(new java.awt.Color(0, 0, 0));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Codigo de Barras", "Marca", "Preço", "Quantidade"
            }
        ));
        tabela.setToolTipText("");
        tabela.setFillsViewportHeight(true);
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setName(""); // NOI18N
        tabela.setRowHeight(30);
        tabela.setRowMargin(2);
        tabela.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tabela.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabela.setShowGrid(false);
        tabela.setShowHorizontalLines(true);
        tabela.setShowVerticalLines(true);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nome do Produto:");

        txtNomeProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeProdutoKeyReleased(evt);
            }
        });

        btPesquisarPorNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btPesquisarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/listSearch.png"))); // NOI18N
        btPesquisarPorNome.setText("Ver todos");
        btPesquisarPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btPesquisarPorNome)
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisarPorNome))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        barraAlterar.addTab("Pesquisar Produto por nome    ", jPanel2);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Alterar Produtos:");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel6");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/altera.png"))); // NOI18N

        jLabel12.setText("jLabel6");

        jDesktopPane1.setLayer(barraAlterar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraAlterar)
                .addContainerGap())
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(35, 35, 35))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.procurarAlterar(txtCodigoBarras.getText());
        DefaultTableModel dados = new DefaultTableModel();

        for (Produto p : lista) {
            txtProduto.setText(p.getProduto());
            txtMarca.setText(p.getMarca());
            String precoFormatted = String.format("%.2f", p.getPreco());
            txtPreco.setText(precoFormatted);
            quantidadeTotal.setText(Integer.toString(p.getQuantidade()));
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        Produto prod = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        int qtd;

        if (!txtAcrescentar.getText().isEmpty()) {
            qtd = Integer.parseInt(quantidadeTotal.getText()) + Integer.parseInt(txtAcrescentar.getText());
        } else {
            txtAcrescentar.setText("0");
            qtd = Integer.parseInt(quantidadeTotal.getText());
        }

        prod.setProduto(txtProduto.getText());
        prod.setMarca(txtMarca.getText());

        try {
            prod.setPreco(Double.parseDouble(txtPreco.getText()));

        } catch (NumberFormatException e) {
            String[] options = {"Fechar"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Falha ao tentar alterar os dados do Produto", "ERRO",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        }
        prod.setQuantidade(qtd);
        prod.setCodigoBarras(txtCodigoBarras.getText());

        dao.alterarProduto(prod);
        limparTela();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btPesquisarPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorNomeActionPerformed
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listaProdutosPorNome("");
        DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
        tab.setNumRows(0);

        for (Produto a : lista) {
            tab.addRow(new Object[]{
                a.getProduto(),
                a.getCodigoBarras(),
                a.getMarca(),
                a.getPreco(),
                a.getQuantidade()
            });
        }
        txtNomeProduto.setText("");
    }//GEN-LAST:event_btPesquisarPorNomeActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        barraAlterar.setSelectedIndex(0);
        txtProduto.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtCodigoBarras.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtMarca.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtPreco.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        quantidadeTotal.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
        limparTabela();
    }//GEN-LAST:event_tabelaMouseClicked

    private void txtNomeProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdutoKeyReleased
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listaProdutosPorNome(txtNomeProduto.getText());
        DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
        tab.setNumRows(0);

        for (Produto a : lista) {
            tab.addRow(new Object[]{
                a.getProduto(),
                a.getCodigoBarras(),
                a.getMarca(),
                a.getPreco(),
                a.getQuantidade()
            });
        }
    }//GEN-LAST:event_txtNomeProdutoKeyReleased

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void limparTela() {
        txtProduto.setText("");
        txtCodigoBarras.setText("");
        txtMarca.setText("");
        txtPreco.setText("");
        quantidadeTotal.setText("");
        txtAcrescentar.setText("");
    }

    private void limparTabela() {
        txtNomeProduto.setText("");
        DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
        tab.setNumRows(0);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane barraAlterar;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btPesquisarPorNome;
    private javax.swing.JButton btVoltar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel quantidadeTotal;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtAcrescentar;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
