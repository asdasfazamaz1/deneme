package deneme;

public class TermNode {
    private Term term;
    private TermNode next;

    public TermNode(Term term) {
        this.term = term;
        this.next = null;
    }

    // Getter and setter methods
    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public TermNode getNext() {
        return next;
    }

    public void setNext(TermNode next) {
        this.next = next;
    }
    
    // Method to get the data (term) stored in the node
    public Term getData() {
        return term;
    }
}
