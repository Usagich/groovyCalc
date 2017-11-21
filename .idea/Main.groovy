import com.beust.jcommander.converters.DoubleConverter

class Operations
{
    double inputNumber;

    Operations(double inputNumber)
    {
        this.inputNumber = inputNumber;
    }

    Operations()
    {
        this.inputNumber = 0;
    }

    //overloads
    Operations plus(Operations right) {return new Operations(this.inputNumber + right.inputNumber);}
    Operations minus(Operations right) {return new Operations(this.inputNumber - right.inputNumber);}
    Operations multiply(Operations right) {return new Operations(this.inputNumber * right.inputNumber);}
    Operations div(Operations right) {return new Operations(this.inputNumber / right.inputNumber);}
    Operations mod(Operations right) {return new Operations(this.inputNumber % right.inputNumber);}
    Operations power(Operations right) {return new Operations(this.inputNumber ** right.inputNumber);}

    static operations = ["+", "-", "*", "/", "%", "**"];

    //getter-setter
    double getNumber() {return inputNumber;}
    void setNumber(double newNumber) {this.inputNumber = newNumber;}
}
static main(args)
{
    Operations leftNumber = new Operations();
    Operations rightNumber = new Operations();

    Scanner readln= new Scanner(System.in);
    //def readln = javax.swing.JOptionPane.&showInputDialog;

    while (true)
    {

        println "Welcome to trial calc!";
        println "List of operations: +, -, *, /, %, **"; //gstring????????
        println 'Please, give me your first number:';
        def tempNumber = readln.nextLine();

        try
        {
            leftNumber.setNumber(Double.parseDouble(tempNumber));
            println leftNumber.getNumber();
            println 'Please, give me your second number:';

            tempNumber = readln.nextLine();

            rightNumber.setNumber(Double.parseDouble(tempNumber));
            println rightNumber.getNumber();
        }
        catch (NumberFormatException e)
        {
            println "Oops! Something is wrong. Please, try again! Let's start it from the beginning =(";
            continue;
        }

        println "Please, select operation:";
        String operation = readln.nextLine();
        def resultNumber;

        if (Operations.operations.contains(operation))
        {
            switch(operation)
            {
                case Operations.operations[0]:
                    resultNumber = leftNumber + rightNumber;
                    break;
                case Operations.operations[1]:
                    resultNumber = leftNumber - rightNumber;
                    break;
                case Operations.operations[2]:
                    resultNumber = leftNumber * rightNumber;
                    break;
                case Operations.operations[3]:
                    resultNumber = leftNumber / rightNumber;
                    break;
                case Operations.operations[4]:
                    resultNumber = leftNumber % rightNumber;
                    break;
                case Operations.operations[5]:
                    resultNumber = leftNumber ** rightNumber;
                    break;
                default:
                    println "There is no such option!"
                    break;
            }

            resultNumber as Operations;
            println resultNumber.getNumber();
        }
        else
            println "There is no such option!";

        println "If you want to continue press '0':";
        String exit = readln.nextLine();
        if (exit.compareTo("0"))
        {
            System.exit(0);
            break;
        }
    }

}