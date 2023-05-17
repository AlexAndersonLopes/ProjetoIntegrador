package view.programa;

import dao.FechamentoCaixaDAO;
import dao.ProdutoDAO;
import dao.TipoPagamentoDAO;
import dao.UsuarioDAO;
import dao.VendaProdutosDAO;
import dao.VendasDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.FechamentosCaixa;
import model.Produto;
import model.TipoPagamento;
import model.Usuario;
import model.VendaProdutos;
import model.Vendas;
import util.Janelas;
import util.Mensagens;

public class Pagamento extends javax.swing.JFrame {

    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private String descricao;
    DecimalFormat df = new DecimalFormat("#.##");
    double troco, valor, total, soma = 0;
    protected DefaultTableModel listaPagamento, itemVenda;
    int linha = -1;
    private String nomes;
    private Janelas janelas = new Janelas();

    public Usuario getUsuario() {
        return usuario;
    }

    private Usuario mostrarFuncionario(String nome) {
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.mostrarFuncionario(nome);
        return usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        tipoPagamento.setText(descricao);
    }

    public Pagamento(String nome) {
        initComponents();
        usuario = mostrarFuncionario(nome);
        nomes = usuario.getUsuario();
        txtCpf.requestFocus();
    }

    public Pagamento(String nome, double total, DefaultTableModel lista) {
        initComponents();
        usuario = mostrarFuncionario(nome);
        nomes = usuario.getUsuario();
        mostrarTotal.setText(String.valueOf(total));
        this.total = total;
        itemVenda = lista;
        txtCpf.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane(){
            ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/fundo.png"));
            Image image = icon.getImage();
            public void paintComponent(Graphics g){
                super.paintComponent(g); // Chama o método paintComponent da superclasse
                g.drawImage(image, 0,0, getWidth(), getHeight(),this);
            }

        };
        jPanel2 = new javax.swing.JPanel();
        tipoPagamento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        mostrarTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtValor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        mostrarTroco = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btDinheiro = new javax.swing.JButton();
        btCredito = new javax.swing.JButton();
        btPIX = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        btFinalizarPagamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPagamento = new javax.swing.JTable();
        btDebito = new javax.swing.JButton();
        btExcluirLinha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tipoPagamento.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        tipoPagamento.setForeground(new java.awt.Color(0, 0, 0));
        tipoPagamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoPagamento.setToolTipText("");
        tipoPagamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Pagamento/Operação");

        jPanel6.setBackground(new java.awt.Color(255, 255, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 3));

        mostrarTotal.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        mostrarTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Total da Venda");

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtValor.setBackground(new java.awt.Color(255, 255, 51));
        txtValor.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        txtValor.setForeground(new java.awt.Color(0, 0, 0));
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));

        mostrarTroco.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        mostrarTroco.setForeground(new java.awt.Color(204, 0, 0));
        mostrarTroco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarTroco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarTroco, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Valor");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("A pagar / Troco");

        btDinheiro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/dinheiro.png"))); // NOI18N
        btDinheiro.setText("    Dinheiro");
        btDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDinheiroActionPerformed(evt);
            }
        });

        btCredito.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cartao.png"))); // NOI18N
        btCredito.setText("     Crédito");
        btCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreditoActionPerformed(evt);
            }
        });

        btPIX.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btPIX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pix.png"))); // NOI18N
        btPIX.setText("     PIX");
        btPIX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPIXActionPerformed(evt);
            }
        });

        voltar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        voltar.setText("Voltar para Compras");
        voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        btFinalizarPagamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btFinalizarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/OK.png"))); // NOI18N
        btFinalizarPagamento.setText("Finalizar Pagamento");
        btFinalizarPagamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255), 2));
        btFinalizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarPagamentoActionPerformed(evt);
            }
        });

        tabelaPagamento.setBackground(new java.awt.Color(255, 255, 255));
        tabelaPagamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tabelaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPagamento.setFillsViewportHeight(true);
        tabelaPagamento.setRowHeight(30);
        tabelaPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPagamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPagamento);

        btDebito.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cartao.png"))); // NOI18N
        btDebito.setText("     Débito");
        btDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDebitoActionPerformed(evt);
            }
        });

        btExcluirLinha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btExcluirLinha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btExcluirLinha.setText("Excluír Pagamento");
        btExcluirLinha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));
        btExcluirLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirLinhaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("CPF Cliente:");

        txtCpf.setBackground(new java.awt.Color(204, 255, 255));
        txtCpf.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfKeyPressed(evt);
            }
        });

        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btDinheiro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btCredito, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btPIX, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btFinalizarPagamento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btDebito, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btExcluirLinha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCpf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel5)
                        .addGap(98, 98, 98))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                .addGap(501, 501, 501)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel2)
                                .addGap(387, 387, 387)
                                .addComponent(jLabel4)
                                .addGap(320, 320, 320)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addComponent(btDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(178, 178, 178))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btPIX, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(jLabel3))
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE))))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(btExcluirLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btFinalizarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExcluirLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPIX, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btFinalizarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel5))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFinalizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarPagamentoActionPerformed
        if (soma >= total) {
            Vendas vendas = new Vendas();
            java.util.Date dataJava = Calendar.getInstance().getTime();
            java.sql.Date dataSql = new java.sql.Date(dataJava.getTime());

            vendas.setData(dataSql);
            vendas.setUsuario(usuario);
            vendas.setTotal(total);
            vendas.setCpfCliente(txtCpf.getText());

            VendasDAO dao = new VendasDAO();
            dao.efetuarVenda(vendas); //Cadastrar na tabela cadVendas           
            vendas.setId(dao.vendaAtual());//Pegar o ID da venda atual

            for (int i = 0; i < itemVenda.getRowCount(); i++) {
                VendaProdutosDAO vpDAO = new VendaProdutosDAO();
                ProdutoDAO pDAO = new ProdutoDAO();
                VendaProdutos vp = new VendaProdutos();
                Produto pro = new Produto();
                pro = pDAO.idProduto(itemVenda.getValueAt(i, 1).toString());

                vp.setQuantidade(Integer.parseInt(itemVenda.getValueAt(i, 3).toString()));
                vp.setSubTotal(Double.parseDouble(itemVenda.getValueAt(i, 4).toString()));
                vp.setProduto(pro);
                vp.setVendas(vendas);

                vpDAO.listaItemVenda(vp);
            }

            for (int i = 0; i < listaPagamento.getRowCount(); i++) {
                TipoPagamentoDAO tDAO = new TipoPagamentoDAO();
                TipoPagamento tipo = new TipoPagamento();

                tipo.setDescricao(listaPagamento.getValueAt(i, 0).toString());
                tipo.setValor(Double.parseDouble(listaPagamento.getValueAt(i, 1).toString()));
                tipo.setVenda(vendas);

                tDAO.tipoPagamento(tipo);
            }
            
            for (int i = 0; i < listaPagamento.getRowCount(); i++) {
                FechamentoCaixaDAO fDAO = new FechamentoCaixaDAO();
                FechamentosCaixa caixa = new FechamentosCaixa();
                
                caixa.setDescricao(listaPagamento.getValueAt(i, 0).toString());
                caixa.setValor(Double.parseDouble(listaPagamento.getValueAt(i, 1).toString()));
                caixa.setUsuario(usuario);
                
                fDAO.cadastrarFechamentoCaixa(caixa);
            }

            this.dispose();
            janelas.irVenda3(nomes);

        } else {
            if(troco == 0){
                Mensagens.mensagemAlerta("Pagamento incompleto, falta R$ " + total);
            }if(troco > 0){
                Mensagens.mensagemAlerta("Pagamento incompleto, falta R$ " + troco);
            }       
        }
    }//GEN-LAST:event_btFinalizarPagamentoActionPerformed

    private void btDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDinheiroActionPerformed
        setDescricao("Dinheiro");
        txtValor.setText("");
        txtValor.requestFocus();
    }//GEN-LAST:event_btDinheiroActionPerformed

    private void btCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreditoActionPerformed
        setDescricao("Crédito");
        adicionalBotoes();
    }//GEN-LAST:event_btCreditoActionPerformed

    private void btDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDebitoActionPerformed
        setDescricao("Débito");
        adicionalBotoes();
    }//GEN-LAST:event_btDebitoActionPerformed

    private void btPIXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPIXActionPerformed
        setDescricao("PIX");
        adicionalBotoes();
    }//GEN-LAST:event_btPIXActionPerformed

    private void adicionalBotoes() {
        if (soma == 0) {
            txtValor.setText(String.valueOf(total));
            txtValor.requestFocus();
        } else {
            valor = Math.abs(soma - total); //MATH VALOR ABSOLUTO 
            txtValor.setText(String.valueOf(df.format(valor)));
            txtValor.requestFocus();
        }

    }

    private void txtValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyPressed
        try {
            if (!tipoPagamento.getText().isEmpty()) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (soma == 0 || soma < total) {
                        valor = Double.parseDouble(txtValor.getText().replace(",", "."));
                        soma = BigDecimal.valueOf(soma).add(BigDecimal.valueOf(valor)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        troco = BigDecimal.valueOf(Math.abs(total - soma)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        String formattedTroco = df.format(troco);
                        mostrarTroco.setText(formattedTroco);
                        evt.consume();

                        if (tipoPagamento.getText().equals("Dinheiro") /*&& valor > total || valor > troco*/) {
                            if (valor > total || valor > troco) {
                                double val;
                                val = valor - troco;
                                valor = val;
                            }
                        }

                        if (soma > total && !tipoPagamento.getText().equals("Dinheiro")) {
                            Mensagens.mensagemErro("Pagamento maior que o Total da Compra!");
                            soma = BigDecimal.valueOf(soma).subtract(BigDecimal.valueOf(valor)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            troco = BigDecimal.valueOf(Math.abs(total - soma)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            mostrarTroco.setText(df.format(troco));
                            txtValor.setText("");

                        } else {
                            listaPagamento = (DefaultTableModel) tabelaPagamento.getModel();
                            listaPagamento.addRow(new Object[]{
                                descricao,
                                BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP).doubleValue()});
                        }
                    }
                }
            } else {
                Mensagens.mensagemAlerta("Selecione o metodo de Pagamento");
                txtValor.setText("");
            }
        } catch (NumberFormatException e) {
            Mensagens.mensagemErro("Insira um valor valído");
            txtValor.setText("");
        }
    }//GEN-LAST:event_txtValorKeyPressed

    private void tabelaPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPagamentoMouseClicked
        linha = tabelaPagamento.getSelectedRow();
        if (linha >= 0) {
            descricao = (String) listaPagamento.getValueAt(linha, 0);
            valor = (Double) listaPagamento.getValueAt(linha, 1);
        }
    }//GEN-LAST:event_tabelaPagamentoMouseClicked

    private void btExcluirLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirLinhaActionPerformed
        if (linha >= 0) {
            double valorExcluido = (Double) listaPagamento.getValueAt(linha, 1);
            soma -= valorExcluido;
            listaPagamento.removeRow(linha);
            listaPagamento.fireTableDataChanged();
            valor = Math.abs(soma - total);
            mostrarTroco.setText(df.format(valor));
            linha = -1;
        } else {
            Mensagens.mensagemErro("Selecione o pagamento que deseja excluír");
        }
    }//GEN-LAST:event_btExcluirLinhaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void txtCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCpf.setEditable(false);
        }
    }//GEN-LAST:event_txtCpfKeyPressed

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
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagamento("nome").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCredito;
    private javax.swing.JButton btDebito;
    private javax.swing.JButton btDinheiro;
    private javax.swing.JButton btExcluirLinha;
    private javax.swing.JButton btFinalizarPagamento;
    private javax.swing.JButton btPIX;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel mostrarTotal;
    private javax.swing.JLabel mostrarTroco;
    private javax.swing.JTable tabelaPagamento;
    private javax.swing.JLabel tipoPagamento;
    protected javax.swing.JFormattedTextField txtCpf;
    protected javax.swing.JTextField txtValor;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
