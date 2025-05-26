package hexcells;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

/**
 * Стартовое окно приложения Hexcells, отображающее главное меню.
 */
public class MenuWindow extends JFrame {
    private JButton playLevel1Button;
    private JButton playLevel2Button;
    private JButton playLevel3Button;
    private JButton exitButton;

    /**
     * Конструктор, создающий главное меню.
     */
    public MenuWindow() {
        // Настройка окна
        setTitle("Hexcells - Главное Меню");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10)); // 6 строк, 1 столбец, отступы 10 пикселей

        // Создание панели для кнопок
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Отступы

        // Создание кнопок
        playLevel1Button = new JButton("Уровень 1");
        playLevel2Button = new JButton("Уровень 2");
        playLevel3Button = new JButton("Уровень 3");
        exitButton = new JButton("Выход");

        // Добавление кнопок на панель
        panel.add(playLevel1Button);
        panel.add(playLevel2Button);
        panel.add(playLevel3Button);
        panel.add(exitButton);

        // Добавление ActionListener для кнопок
        playLevel1Button.addActionListener(e -> startLevel("level1.txt"));
        playLevel2Button.addActionListener(e -> startLevel("level2.txt"));
        playLevel3Button.addActionListener(e -> startLevel("level3.txt"));
        exitButton.addActionListener(e -> System.exit(0));

        // Добавление панели в окно
        add(panel);

        // Упаковка и отображение
        pack();
        setLocationRelativeTo(null); // Центрирование окна
        setVisible(true);
    }

    /**
     * Запускает уровень, загружая конфигурацию из указанного файла.
     *
     * @param filePath Путь к файлу уровня
     */
    private void startLevel(String filePath) {
        try {
            // Загрузка конфигурации уровня
            LevelConfig config = LevelFile.loadLevelFromFile(filePath);

            // Создание доски
            Board board = new Board(config.getRows(), config.getCols());
            board.initializeLevel(config);

            // Создание игрового окна
            GameWindow gameWindow = new GameWindow(board);
            gameWindow.setVisible(true);

            // Скрытие меню
            setVisible(false);
        } catch (IOException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Ошибка загрузки уровня: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}