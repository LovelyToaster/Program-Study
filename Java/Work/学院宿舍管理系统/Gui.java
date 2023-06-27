package 学院宿舍管理系统;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class Gui {
    public void Login_Frame(Student stu) throws IOException, ClassNotFoundException {
        Login login = new Login();
        login.user_out();
        JFrame frame = new JFrame("登录");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // 将窗口置于屏幕中央

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        // 账号标签和文本框
        JLabel accountLabel = new JLabel("账号:");
        JTextField accountTextField = new JTextField(15);
        // 密码标签和文本框
        JLabel passwordLabel = new JLabel("密码:");
        JPasswordField passwordField = new JPasswordField(15);

        // 登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String frame_name = accountTextField.getText();
                String frame_password = String.valueOf(passwordField.getPassword());
                int i = login.password_verify(frame_name, frame_password);
                if (i == 0) {
                    JOptionPane.showMessageDialog(frame, "登录成功");
                    frame.dispose();
                    Main_Frame(stu);
                } else if (i == 2) {
                    JOptionPane.showMessageDialog(frame, "请输入用户名");
                } else {
                    JOptionPane.showMessageDialog(frame, "用户名或密码错误");
                }
            }
        });
        // 注册按钮
        JButton registerButton = new JButton("注册");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String frame_new_name = accountTextField.getText();
                String frame_new_password = String.valueOf(passwordField.getPassword());
                try {
                    int i = login.user_register(frame_new_name, frame_new_password);
                    if (i == 0) {
                        JOptionPane.showMessageDialog(frame, "注册成功");
                    } else if (i == 1) {
                        JOptionPane.showMessageDialog(frame, "请输入用户名或密码");
                    } else {
                        JOptionPane.showMessageDialog(frame, "用户名重复");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // 将组件添加到面板中
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(accountLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(accountTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(20, 5, 5, 5); // 调整上方间距
        panel.add(loginButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(20, 5, 5, 5); // 调整上方间距
        panel.add(registerButton, constraints);

        frame.add(panel);
        frame.setVisible(true);

    }

    public void Main_Frame(Student stu) {
        // 创建主窗口
        JFrame frame = new JFrame("学生宿舍信息管理系统");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setBackground(new Color(135, 206, 235));

        // 创建标题标签
        JLabel titleLabel = new JLabel("欢迎使用学生宿舍信息管理系统", SwingConstants.CENTER);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);

        // 创建按钮
        JButton addButton = new JButton("添加学生信息");
        addButton.setBackground(new Color(70, 130, 180));
        addButton.setFont(new Font("宋体", Font.BOLD, 20));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);

        JButton managementButton = new JButton("管理学生信息");
        managementButton.setBackground(new Color(70, 130, 180));
        managementButton.setFont(new Font("宋体", Font.BOLD, 20));
        managementButton.setForeground(Color.WHITE);
        managementButton.setFocusPainted(false);
        managementButton.setBorderPainted(false);

        JButton viewButton = new JButton("查看学生信息");
        viewButton.setBackground(new Color(70, 130, 180));
        viewButton.setFont(new Font("宋体", Font.BOLD, 20));
        viewButton.setForeground(Color.WHITE);
        viewButton.setFocusPainted(false);
        viewButton.setBorderPainted(false);

        // 添加按钮点击事件监听器
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Add_Frame(stu);
            }
        });

        managementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Management_Frame(stu);
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                View_Frame(stu);
            }
        });

        // 将组件添加到面板中
        panel.add(titleLabel);
        panel.add(addButton);
        panel.add(managementButton);
        panel.add(viewButton);

        // 将面板添加到主窗口中
        frame.add(panel, BorderLayout.CENTER);

        // 显示主窗口
        frame.setVisible(true);
    }

    public void Add_Frame(Student stu) {
        // 创建主窗口
        JFrame frame = new JFrame("学生宿舍信息管理系统");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(135, 206, 235));

        // 创建标题标签
        JLabel titleLabel = new JLabel("添加学生信息", SwingConstants.CENTER);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        // 创建输入框和标签
        JPanel inputPanel_lable = new JPanel();
        inputPanel_lable.setLayout(new GridLayout(10, 2));
        inputPanel_lable.setBackground(new Color(135, 206, 235));

        JPanel inputPanel_text = new JPanel();
        inputPanel_text.setLayout(new GridLayout(10, 2));
        inputPanel_text.setBackground(new Color(135, 206, 235));

        JLabel noLabel = new JLabel("学号：");
        JLabel nameLabel = new JLabel("姓名：");
        JLabel sexLabel = new JLabel("性别：");
        JLabel instituteLabel = new JLabel("院部：");
        JLabel dormitoryLabel = new JLabel("宿舍楼：");
        JLabel dormitory_numberLabel = new JLabel("宿舍号：");
        JLabel phoneLabel = new JLabel("电话：");

        noLabel.setFont(new Font("宋体", Font.BOLD, 20));
        nameLabel.setFont(new Font("宋体", Font.BOLD, 20));
        sexLabel.setFont(new Font("宋体", Font.BOLD, 20));
        instituteLabel.setFont(new Font("宋体", Font.BOLD, 20));
        dormitoryLabel.setFont(new Font("宋体", Font.BOLD, 20));
        dormitory_numberLabel.setFont(new Font("宋体", Font.BOLD, 20));
        phoneLabel.setFont(new Font("宋体", Font.BOLD, 20));

        JTextField noTextField = new JTextField();
        JTextField nameTextField = new JTextField();
        JTextField sexTextField = new JTextField();
        JTextField instituteTextField = new JTextField();
        JTextField dormitoryTextField = new JTextField();
        JTextField dormitory_numberTextField = new JTextField();
        JTextField phoneTextField = new JTextField();

        inputPanel_lable.add(noLabel);
        inputPanel_text.add(noTextField);
        inputPanel_lable.add(nameLabel);
        inputPanel_text.add(nameTextField);
        inputPanel_lable.add(sexLabel);
        inputPanel_text.add(sexTextField);
        inputPanel_lable.add(instituteLabel);
        inputPanel_text.add(instituteTextField);
        inputPanel_lable.add(dormitoryLabel);
        inputPanel_text.add(dormitoryTextField);
        inputPanel_lable.add(dormitory_numberLabel);
        inputPanel_text.add(dormitory_numberTextField);
        inputPanel_lable.add(phoneLabel);
        inputPanel_text.add(phoneTextField);

        // 创建添加按钮
        JButton addButton = new JButton("添加");
        addButton.setBackground(new Color(70, 130, 180));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);

        // 添加按钮点击事件监听器
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student stu_data = new Student();
                stu_data.no = noTextField.getText();
                stu_data.name = nameTextField.getText();
                stu_data.sex = sexTextField.getText();
                stu_data.institute = instituteTextField.getText();
                stu_data.dormitory = dormitoryTextField.getText();
                stu_data.dormitory_number = dormitory_numberTextField.getText();
                stu_data.phone = phoneTextField.getText();
                int i = stu.add_student(stu_data);
                if (i == 0) {
                    JOptionPane.showMessageDialog(frame, "添加成功！");
                } else {
                    JOptionPane.showMessageDialog(frame, "添加失败,学号发生重复！");
                    return;
                }
                Main_Frame(stu);
            }
        });

        // 将组件添加到面板中
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(inputPanel_lable, BorderLayout.LINE_START);
        panel.add(inputPanel_text, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        // 将面板添加到主窗口中
        frame.add(panel, BorderLayout.CENTER);

        // 显示主窗口
        frame.setVisible(true);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Main_Frame(stu);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void Management_Frame(Student stu) {
        JFrame frame = new JFrame("学生宿舍信息管理系统");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // 创建表格模型
        String[] columnNames = { "学号", "姓名", "性别", "院部", "宿舍楼", "宿舍号", "电话" };
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DefaultTableModel stu_view = (DefaultTableModel) table.getModel();
        stu_view.setColumnIdentifiers(columnNames);
        for (Student s : stu.student_manage) {
            stu_view.addRow(stu.get_student(s));
        }

        // 创建表格
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        JButton deleteButton = new JButton("删除");
        JButton modButton = new JButton("修改");
        JButton searchButton = new JButton("查询");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // 获取选中的行索引
                    String student_no = (String) table.getValueAt(selectedRow, 0);
                    // 显示删除成功的消息框
                    int i = JOptionPane.showConfirmDialog(frame, "你确定要删除该信息吗？", "注意", JOptionPane.OK_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (i == JOptionPane.OK_OPTION) {
                        // 执行删除学生宿舍操作的代码
                        stu.delete_student(student_no);
                        // 从表格模型中删除选中行
                        stu_view.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(frame, "删除成功!");
                    }
                } else {
                    // 如果没有选中任何行，显示提示消息框
                    JOptionPane.showMessageDialog(frame, "请选择要删除的学生!");
                }
            }
        });
        modButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    JDialog stu_dialog = new JDialog();
                    JButton confirmButton = new JButton("确认");
                    stu_dialog.setSize(400, 300);
                    stu_dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    stu_dialog.setLocationRelativeTo(null);
                    stu_dialog.setTitle("请输入信息");

                    JTextField stu_no = new JTextField((String) table.getValueAt(selectedRow, 0), 80);
                    JTextField stu_name = new JTextField((String) table.getValueAt(selectedRow, 1), 80);
                    JTextField stu_sex = new JTextField((String) table.getValueAt(selectedRow, 2), 80);
                    JTextField stu_institute = new JTextField((String) table.getValueAt(selectedRow, 3), 80);
                    JTextField stu_dormitory = new JTextField((String) table.getValueAt(selectedRow, 4), 80);
                    JTextField stu_dormitory_number = new JTextField((String) table.getValueAt(selectedRow, 5), 80);
                    JTextField stu_phone = new JTextField((String) table.getValueAt(selectedRow, 6), 80);

                    JPanel panel = new JPanel(new GridLayout(7, 2));
                    panel.add(new JLabel("学号"));
                    panel.add(stu_no);
                    panel.add(new JLabel("姓名"));
                    panel.add(stu_name);
                    panel.add(new JLabel("性别"));
                    panel.add(stu_sex);
                    panel.add(new JLabel("院部"));
                    panel.add(stu_institute);
                    panel.add(new JLabel("宿舍楼"));
                    panel.add(stu_dormitory);
                    panel.add(new JLabel("宿舍号"));
                    panel.add(stu_dormitory_number);
                    panel.add(new JLabel("电话"));
                    panel.add(stu_phone);

                    confirmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Student s = new Student();
                            s.no = stu_no.getText();
                            s.name = stu_name.getText();
                            s.sex = stu_sex.getText();
                            s.institute = stu_institute.getText();
                            s.dormitory = stu_dormitory.getText();
                            s.dormitory_number = stu_dormitory_number.getText();
                            s.phone = stu_phone.getText();
                            stu.modify_student(s.no, s);
                            Student Student_info = stu.search_student(s.no);
                            stu_view.setRowCount(0);
                            stu_view.addRow(stu.get_student(Student_info));
                            stu_dialog.dispose();
                        }
                    });
                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    buttonPanel.add(confirmButton);

                    stu_dialog.getContentPane().setLayout(new BorderLayout());
                    stu_dialog.getContentPane().add(panel, BorderLayout.CENTER);
                    stu_dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                    stu_dialog.setModal(true);
                    stu_dialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "请选择要修改的学生!");
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] option = { "通过学号查询", "(x)通过姓名查询", "(x)通过性别查询", "(x)通过院部查询", "占位" };
                String info = (String) JOptionPane.showInputDialog(frame, "请选择查询方式", "提示", JOptionPane.QUESTION_MESSAGE,
                        null, option, option[0]);
                if (info != null && info.equals(option[0])) {
                    String student_no = JOptionPane.showInputDialog(frame, "请输入学号", "输入", JOptionPane.QUESTION_MESSAGE);
                    Student Student_info = stu.search_student(student_no);
                    stu_view.setRowCount(0);
                    stu_view.addRow(stu.get_student(Student_info));
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(searchButton);
        buttonPanel.add(modButton);
        buttonPanel.add(deleteButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Main_Frame(stu);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void View_Frame(Student stu) {
        // 创建主窗口
        JFrame frame = new JFrame("学生宿舍信息管理系统");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // 创建显示区域
        String[] columnNames = { "学号", "姓名", "性别", "院部", "宿舍楼", "宿舍号", "电话" };
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        DefaultTableModel stu_view = (DefaultTableModel) table.getModel();
        stu_view.setColumnIdentifiers(columnNames);
        for (Student s : stu.student_manage) {
            stu_view.addRow(stu.get_student(s));
        }

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(135, 206, 235));

        // 创建标题标签
        JLabel titleLabel = new JLabel("所有的学生宿舍信息", SwingConstants.CENTER);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        // 创建滚动面板
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        // 将组件添加到面板中
        panel.add(titleLabel, BorderLayout.PAGE_START);
        panel.add(scrollPane, BorderLayout.CENTER);

        // 将面板添加到主窗口中
        frame.add(panel, BorderLayout.CENTER);

        // 显示主窗口
        frame.setVisible(true);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Main_Frame(stu);
            }

            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

        });
    }
}