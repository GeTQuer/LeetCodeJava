public class ListNode {
    public int val;
    public ListNode next;

    // Конструктор без параметров
    public ListNode() {}

    // Конструктор для создания узла со значением
    public ListNode(int val) {
        this.val = val;
    }

    // Конструктор для создания узла со значением и ссылкой на следующий узел
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}