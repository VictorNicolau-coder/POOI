import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Shop {

    Scanner in = new Scanner(System.in);
    ArrayList<String> ingredients = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();
    
    Map<String, Double> breads = Map.of(
        "Pão Francês", 0.25,
        "Pão Carteira", 0.30,
        "Pão de Hambúrguer", 0.70,
        "Pão Árabe", 1.30 
    );

    Map<String, Double> cheeses = Map.of(
        "Coalho", 1.50,
        "Minas", 1.80,
        "Muçarela", 2.00,
        "Cream Cheese", 3.00,
        "Gorgonzola", 3.50
    );

    Map<String, Double> meats = Map.of(
        "Mortadela", 0.50,
        "Apresuntado", 1.00,
        "Bacon", 1.30,
        "Presunto", 1.60,
        "Pepperoni", 1.80,
        "Salame", 2.00
    );

    Map<String, Double> vegetables = Map.of(
        "Cebola", 0.30,
        "Pimentão", 0.45,
        "Tomate", 0.50
    );

    Map<String, Double> sauces = Map.of(
        "Maionese", 0.50,
        "Ketchup", 0.50,
        "Maionese Temperada", 0.70,
        "Molho Tártaro", 1.00,
        "Barbecue", 1.50
    );

    Map<String, Double> extras = Map.of(
        "Batata Palha", 1.00,
        "Ovo", 1.00
    );

    Shop(){
        System.out.println("Bem vindo ao 'Lanchonete DoisIrmãos'");
    }

    void process(){
        System.out.println("Monte seu sanduíche! \n Escolha o primeiro ingrediente digitando o número associado:");
        
        while (true){

            System.out.println(" 1. Pães;");
            System.out.println(" 2. Queijos;");
            System.out.println(" 3. Carnes;");
            System.out.println(" 4. Verduras;");
            System.out.println(" 5. Sauce;");
            System.out.println(" 6. Outros;");

            System.out.println("Caso deseje encerrar digite 0.\n");
            
            System.out.print("R: ");
            var resp = in.nextInt();

            if (resp == 0) break;

            switch (resp) {
                case 1: ingredients.add(pickBread()); break;
                case 2: ingredients.add(pickCheese()); break;
                case 3: ingredients.add(pickMeat()); break;
                case 4: ingredients.add(pickSalad()); break;
                case 5: ingredients.add(pickSauce()); break;
                case 6: ingredients.add(pickOther()); break;
                
                default:
                    System.out.println("A opção escolhida é inexistente");
                    break;
            }


        }

        System.out.println("Seu hamburguer foi contruido desta forma: ");
        for (String string : ingredients) {
            if (breads.containsKey(string))
                values.add(breads.get(string));
            else if (cheeses.containsKey(string))
                values.add(cheeses.get(string));
            else if (meats.containsKey(string))
                values.add(meats.get(string));
            else if (vegetables.containsKey(string))
                values.add(vegetables.get(string));
            else if (extras.containsKey(string))
                values.add(extras.get(string));
            System.out.println(string + " $" + values.get(values.size()-1));
        }
        
        double sum = 0;
        for (Double d : values) { sum += d; }
        
        System.out.printf("Valor total: $%.2f\n", sum);
    }

    String pickBread(){
        String chosenOne = "";

        int count = 1;
        for (Map.Entry<String, Double> entry : breads.entrySet()){
            System.out.printf("%d. %s - %.2f\n", count++, entry.getKey(), entry.getValue());
        }
        
        System.out.print("\nR: ");
        var x = in.nextInt();

        switch (x) {
            case 1: chosenOne = "Pão Francês"; break;
            case 2: chosenOne = "Pão Carteira"; break;
            case 3: chosenOne = "Pão de Hamburguer"; break;
            case 4: chosenOne = "Pão Árabe"; break;
            default: break;
        }

        return chosenOne;
    }
    
    String pickCheese(){
        String chosenOne = "";
    
        int count = 1;
        for (Map.Entry<String, Double> entry : cheeses.entrySet()) {
            System.out.printf("%d. %s - R$ %.2f\n", count++, entry.getKey(), entry.getValue());
        }
    
        System.out.print("\nR: ");
        int x = in.nextInt();
    
        switch (x) {
            case 1: chosenOne = "Coalho"; break;
            case 2: chosenOne = "Minas"; break;
            case 3: chosenOne = "Muçarela"; break;
            case 4: chosenOne = "Cream Cheese"; break;
            case 5: chosenOne = "Gorgonzola"; break;
            default: break;
        }
    
        return chosenOne;
    }
    
    String pickMeat(){
        String chosenOne = "";
    
        int count = 1;
        for (Map.Entry<String, Double> entry : meats.entrySet()) {
            System.out.printf("%d. %s - R$ %.2f\n", count++, entry.getKey(), entry.getValue());
        }
    
        System.out.print("\nR: ");
        int x = in.nextInt();
    
        switch (x) {
            case 1: chosenOne = "Mortadela"; break;
            case 2: chosenOne = "Apresuntado"; break;
            case 3: chosenOne = "Bacon"; break;
            case 4: chosenOne = "Presunto"; break;
            case 5: chosenOne = "Pepperoni"; break;
            case 6: chosenOne = "Salame"; break;
            default: break;
        }
    
        return chosenOne;
    }
    
    String pickSalad(){
        String chosenOne = "";
    
        int count = 1;
        for (Map.Entry<String, Double> entry : vegetables.entrySet()) {
            System.out.printf("%d. %s - R$ %.2f\n", count++, entry.getKey(), entry.getValue());
        }
    
        System.out.print("\nR: ");
        int x = in.nextInt();
    
        switch (x) {
            case 1: chosenOne = "Cebola"; break;
            case 2: chosenOne = "Pimentão"; break;
            case 3: chosenOne = "Tomate"; break;
            default: break;
        }
    
        return chosenOne;
    }
    
    String pickSauce(){
        String chosenOne = "";
    
        int count = 1;
        for (Map.Entry<String, Double> entry : sauces.entrySet()) {
            System.out.printf("%d. %s - R$ %.2f\n", count++, entry.getKey(), entry.getValue());
        }
    
        System.out.print("\nR: ");
        int x = in.nextInt();
    
        switch (x) {
            case 1: chosenOne = "Maionese"; break;
            case 2: chosenOne = "Ketchup"; break;
            case 3: chosenOne = "Maionese Temperada"; break;
            case 4: chosenOne = "Molho Tártaro"; break;
            case 5: chosenOne = "Barbecue"; break;
            default: break;
        }
    
        return chosenOne;
    }
    
    String pickOther(){
        String chosenOne = "";
    
        int count = 1;
        for (Map.Entry<String, Double> entry : extras.entrySet()) {
            System.out.printf("%d. %s - R$ %.2f\n", count++, entry.getKey(), entry.getValue());
        }
    
        System.out.print("\nR: ");
        int x = in.nextInt();
    
        switch (x) {
            case 1: chosenOne = "Batata Palha"; break;
            case 2: chosenOne = "Ovo"; break;
            default: break;
        }
    
        return chosenOne;
    }    

}
