package hexcells;

import java.util.List;
import java.util.ArrayList;

/**
 * Класс для хранения конфигурации игрового уровня в Hexcells.
 * Содержит размеры сетки, расположение мин и данные для создания правил.
 */
public class LevelConfig {
    private int rows; // Количество строк сетки
    private int cols; // Количество столбцов сетки
    private List<HexCoord> mineCoordinates; // Координаты мин
    private List<RuleData> ruleDataList; // Данные для создания правил

    /**
     * Конструктор, инициализирующий конфигурацию уровня.
     * @param rows Количество строк
     * @param cols Количество столбцов
     * @param mineCoordinates Список координат мин
     * @param ruleDataList Список данных для правил
     * @throws IllegalArgumentException если входные данные недопустимы
     */
    public LevelConfig(int rows, int cols, List<HexCoord> mineCoordinates, List<RuleData> ruleDataList) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Размеры сетки должны быть положительными: rows=" + rows + ", cols=" + cols);
        }
        if (mineCoordinates == null) {
            throw new IllegalArgumentException("Список координат мин не может быть null");
        }
        if (ruleDataList == null) {
            throw new IllegalArgumentException("Список данных правил не может быть null");
        }
        this.rows = rows;
        this.cols = cols;
        this.mineCoordinates = new ArrayList<>(mineCoordinates); // Копия для защиты
        this.ruleDataList = new ArrayList<>(ruleDataList); // Копия для защиты
    }

    // Геттеры
    /**
     * Возвращает количество строк.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Возвращает количество столбцов.
     */
    public int getCols() {
        return cols;
    }

    /**
     * Возвращает список координат мин.
     */
    public List<HexCoord> getMines() {
        return new ArrayList<>(mineCoordinates); // Копия для защиты
    }

    /**
     * Возвращает список данных для правил.
     */
    public List<RuleData> getRuleDataList() {
        return new ArrayList<>(ruleDataList); // Копия для защиты
    }

    // Сеттеры
    /**
     * Устанавливает количество строк.
     * @param rows Новое количество строк
     * @throws IllegalArgumentException если rows <= 0
     */
    public void setRows(int rows) {
        if (rows <= 0) {
            throw new IllegalArgumentException("Количество строк должно быть положительным");
        }
        this.rows = rows;
    }

    /**
     * Устанавливает количество столбцов.
     * @param cols Новое количество столбцов
     * @throws IllegalArgumentException если cols <= 0
     */
    public void setCols(int cols) {
        if (cols <= 0) {
            throw new IllegalArgumentException("Количество столбцов должно быть положительным");
        }
        this.cols = cols;
    }

    /**
     * Устанавливает список координат мин.
     * @param mineCoordinates Новый список координат мин
     * @throws IllegalArgumentException если mineCoordinates null
     */
    public void setMineCoordinates(List<HexCoord> mineCoordinates) {
        if (mineCoordinates == null) {
            throw new IllegalArgumentException("Список координат мин не может быть null");
        }
        this.mineCoordinates = new ArrayList<>(mineCoordinates);
    }

    /**
     * Устанавливает список данных для правил.
     * @param ruleDataList Новый список данных для правил
     * @throws IllegalArgumentException если ruleDataList null
     */
    public void setRuleDataList(List<RuleData> ruleDataList) {
        if (ruleDataList == null) {
            throw new IllegalArgumentException("Список данных правил не может быть null");
        }
        this.ruleDataList = new ArrayList<>(ruleDataList);
    }
}

