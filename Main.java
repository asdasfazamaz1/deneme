package deneme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            int numLines = Integer.parseInt(reader.readLine().trim());

            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();

            for (int i = 0; i < numLines; i++) {
                String line = reader.readLine().trim();
                String[] terms = line.split("\\s+");
                processLine(polynomial1, terms); // processLine metodu burada çağrılıyor
            }

            // İkinci satır için aynı işlemi yapabilirsiniz

            reader.close();

            // Toplama işlemi
            Polynomial sumResult = polynomial1.add(polynomial2);

            // Çıkarma işlemi
            Polynomial subtractResult = polynomial1.subtract(polynomial2);

            // Sonuçları output.txt dosyasına yaz
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("result of sum:\n");
            writer.write(sumResult != null ? sumResult.toString() : "failed");
            writer.newLine();

            writer.write("result of sub:\n");
            writer.write(subtractResult != null ? subtractResult.toString() : "failed");
            writer.newLine();

            writer.close();
            System.out.println("Sonuçlar output.txt dosyasına yazıldı.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private static void processLine(Polynomial polynomial, String[] terms) {
        boolean isAddition = true; // Varsayılan olarak toplama işlemi yapılacak

        // Her satırdaki terimleri polinoma ekle
        for (String term : terms) {
            // Terim boş ise atla
            if (term.isEmpty()) {
                continue;
            }

            // İşareti kontrol et
            if (term.equals("+")) {
                isAddition = true; // İşaret + ise toplama işlemi yapılacak
                continue;
            } else if (term.equals("-")) {
                isAddition = false; // İşaret - ise çıkarma işlemi yapılacak
                continue;
            }

            // Terimi işle
            processTerm(polynomial, term, isAddition);
        }
    }

    private static void processTerm(Polynomial polynomial, String term, boolean isAddition) {
        // Terimi parçala ve katsayıyı, x, y, z derecelerini al
        // Örnek bir terim: 5x3y2
        // Katsayı: 5, x derecesi: 3, y derecesi: 2
        int coefficient = 0;
        int degreeX = 0, degreeY = 0, degreeZ = 0;

        String[] parts = term.split("x|y|z");
        if (parts.length > 0) {
            coefficient = Integer.parseInt(parts[0]);
        }
        for (String part : parts) {
            if (part.contains("^")) {
                String[] degreeParts = part.split("\\^");
                if (degreeParts.length == 2) {
                    if (part.contains("x")) {
                        degreeX = Integer.parseInt(degreeParts[1]);
                    } else if (part.contains("y")) {
                        degreeY = Integer.parseInt(degreeParts[1]);
                    } else if (part.contains("z")) {
                        degreeZ = Integer.parseInt(degreeParts[1]);
                    }
                }
            }
        }

        // Oluşturulan katsayı ve derecelerle bir terim oluştur ve polinoma ekle
        Term termToAdd = new Term(coefficient, degreeX, degreeY, degreeZ);
        if (isAddition) {
            polynomial.addTerm(termToAdd);
        } else {
            polynomial.subtractTerm(termToAdd);
        }
    }
}

