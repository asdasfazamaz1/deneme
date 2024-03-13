package deneme;

public class Polynomial {
    private TermNode head;
    private TermNode tail;

    public Polynomial() {
        head = null;
        tail = null;
    }

    // Yeni bir terimi polinoma ekler
    public void addTerm(Term term) {
        TermNode newNode = new TermNode(term);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // Terimi polinomdan çıkarır
    public void subtractTerm(Term term) {
        // İlgili terimi polinomdan çıkar
        TermNode current = head;
        TermNode prev = null;

        while (current != null && !current.getTerm().equals(term)) {
            prev = current;
            current = current.getNext();
        }

        if (current != null) {
            if (prev != null) {
                prev.setNext(current.getNext());
            } else {
                head = current.getNext();
            }

            if (current == tail) {
                tail = prev;
            }
        }
    }

    // İki polinomu toplar
    public Polynomial add(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        TermNode current1 = this.head;
        TermNode current2 = polynomial.head;

        while (current1 != null && current2 != null) {
            // İki terimi topla
            Term sumTerm = current1.getTerm().add(current2.getTerm());
            result.addTerm(sumTerm);
            current1 = current1.getNext();
            current2 = current2.getNext();
        }

        // İlk polinomun kalan terimlerini ekle
        while (current1 != null) {
            result.addTerm(current1.getTerm());
            current1 = current1.getNext();
        }

        // İkinci polinomun kalan terimlerini ekle
        while (current2 != null) {
            result.addTerm(current2.getTerm());
            current2 = current2.getNext();
        }

        return result;
    }

    // İki polinomu çıkarır
    public Polynomial subtract(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        TermNode current1 = this.head;
        TermNode current2 = polynomial.head;

        while (current1 != null && current2 != null) {
            // İki terimi çıkar
            Term subtractTerm = current1.getTerm().subtract(current2.getTerm());
            result.addTerm(subtractTerm);
            current1 = current1.getNext();
            current2 = current2.getNext();
        }

        // İlk polinomun kalan terimlerini ekle
        while (current1 != null) {
            result.addTerm(current1.getTerm());
            current1 = current1.getNext();
        }

        // İkinci polinomun kalan terimlerini çıkar
        while (current2 != null) {
            Term subtractTerm = new Term(-current2.getTerm().getCoefficient(),
                                         current2.getTerm().getDegreeX(),
                                         current2.getTerm().getDegreeY(),
                                         current2.getTerm().getDegreeZ());
            result.addTerm(subtractTerm);
            current2 = current2.getNext();
        }

        return result;
    }

    // Polinomu bir string olarak temsil eder
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        TermNode current = head;
        while (current != null) {
            result.append(current.getTerm()).append(" ");
            current = current.getNext();
        }
        return result.toString();
    }
}
