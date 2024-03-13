package deneme;

public class Term {
    private int coefficient;
    private int degreeX;
    private int degreeY;
    private int degreeZ;

    public Term(int coefficient, int degreeX, int degreeY, int degreeZ) {
        this.coefficient = coefficient;
        this.degreeX = degreeX;
        this.degreeY = degreeY;
        this.degreeZ = degreeZ;
    }

    // Getter ve setter metotları
    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegreeX() {
        return degreeX;
    }

    public void setDegreeX(int degreeX) {
        this.degreeX = degreeX;
    }

    public int getDegreeY() {
        return degreeY;
    }

    public void setDegreeY(int degreeY) {
        this.degreeY = degreeY;
    }

    public int getDegreeZ() {
        return degreeZ;
    }

    public void setDegreeZ(int degreeZ) {
        this.degreeZ = degreeZ;
    }

    // İki terimi toplar
    public Term add(Term term) {
        if (this.degreeX != term.getDegreeX() || this.degreeY != term.getDegreeY() || this.degreeZ != term.getDegreeZ()) {
            throw new IllegalArgumentException("degree is not equal");
        }
        int newCoefficient = this.coefficient + term.getCoefficient();
        return new Term(newCoefficient, this.degreeX, this.degreeY, this.degreeZ);
    }

    // İki terimi çıkarır
    public Term subtract(Term term) {
        if (this.degreeX != term.getDegreeX() || this.degreeY != term.getDegreeY() || this.degreeZ != term.getDegreeZ()) {
            throw new IllegalArgumentException("degree is not equal");
        }
        int newCoefficient = this.coefficient - term.getCoefficient();
        return new Term(newCoefficient, this.degreeX, this.degreeY, this.degreeZ);
    }

    // Terimi bir string olarak temsil eder
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (coefficient != 0) {
            if (coefficient > 0) {
                result.append("+");
            }
            result.append(coefficient);
            if (degreeX > 0) {
                result.append("x^").append(degreeX);
            }
            if (degreeY > 0) {
                result.append("y^").append(degreeY);
            }
            if (degreeZ > 0) {
                result.append("z^").append(degreeZ);
            }
        }
        return result.toString();
    }
}
