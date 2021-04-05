package com.company;

public class Main {

    public static void main(String[] args) {
	// Operators
        int result = 1 + 2; // 1+ 2 = 3 // The = operator assigns everything on  the right to the variable on the left
        System.out.println(result);
        int previousResult = result;
        System.out.println("Previous Results = " + previousResult);
        result = result - 1; // 3 - 1 = 2
        System.out.println("3 - 1 = " + result);
        System.out.println(previousResult);
        result = result * 10; // 2 * 10 = 20
        System.out.println("2 * 10 = " + result);

        result = result / 5; // 20 / 5 = 4
        System.out.println("20 / 5 = " + result);

        result = result % 3; // the remainder of (4 % 3) = 1
        System.out.println(result);

        // Shortcuts
        // result = result + 1
        result ++;
        System.out.println(result);
        result --;
        System.out.println(result);

        // result = result + 2
        result += 2;
        System.out.println(result);

        result +=590;
        System.out.println(result);

        result %=50;
        System.out.println(result);

        result *= 10;
        System.out.println(result);

        // IF THEN STATEMENT
        // Only run the code if the condition in the parenthesis evaluates to true (always use a code block for if then
        // then statement)

        boolean isAlien = false;
        if(!isAlien) {
            System.out.println("It is not an Alien");
        }

        int topScore = 100;
        if(topScore == 100){
            System.out.println("You've  got the highest score!");
        }

        // Logical AND Operator [&&] // & this is the bitwise AND operator and not needed in this situation
        // This operator ensures that both sides of the condition  evaluates to true before executing
        // the code in the next code block
        int secondTopScore = 80;
        if((topScore > secondTopScore) && (topScore >= 100)){
            System.out.println("Great, You have gotten the highest score!!!");
        }

        // Logical OR Operator [||] // | is the bitwise operator and not needed in this situation
        // This condition ensures that one side of the conditions specified to be true and the code block afterwards will
        // execute
        if ((topScore > secondTopScore) || (topScore < secondTopScore)){
            System.out.println("One of the conditions is true:");
        }

        // NOT Operator is also a known as Logical Complement Operator
        boolean isCar = false;
        if(!isCar){
            System.out.println("This is exactly the case it should be...");
        }

        // TERNARY Operator a shortcut for if then else statement
        boolean wasCar = isCar ? true : false;
        if (wasCar){
            System.out.println("wasCar is True:");
        }

        // Conditional Operators
        //  &&      Conditional-AND
        //  ||      Conditional-OR
        //  ?:      Ternary (shorthand for
        //        if-then-else statement)


        // Java Operator Precedence Table
        //Precedence	Operator	Type	Associativity
        //15	()
        //[]
        //·	Parentheses
        //Array subscript
        //Member selection
        //Left to Right
        //14	++
        //--	Unary post-increment
        //Unary post-decrement	Right to left
        //13	++
        //--
        //+
        //-
        //!
        //~
        //( type )	Unary pre-increment
        //Unary pre-decrement
        //Unary plus
        //Unary minus
        //Unary logical negation
        //Unary bitwise complement
        //Unary type cast	Right to left
        //12	*
        ///
        //%	Multiplication
        //Division
        //Modulus	Left to right
        //11	+
        //-	Addition
        //Subtraction	Left to right
        //10	<<
        //>>
        //>>>	Bitwise left shift
        //Bitwise right shift with sign extension
        //Bitwise right shift with zero extension	Left to right
        //9	<
        //<=
        //>
        //>=
        //instanceof	Relational less than
        //Relational less than or equal
        //Relational greater than
        //Relational greater than or equal
        //Type comparison (objects only)	Left to right
        //8	==
        //!=	Relational is equal to
        //Relational is not equal to	Left to right
        //7	&	Bitwise AND	Left to right
        //6	^	Bitwise exclusive OR	Left to right
        //5	|	Bitwise inclusive OR	Left to right
        //4	&&	Logical AND
        //Left to right
        //3	||	Logical OR	Left to right
        //2	? :	Ternary conditional	Right to left
        //1	=
        //+=
        //-=
        //*=
        ///=
        //%=	Assignment
        //Addition assignment
        //Subtraction assignment
        //Multiplication assignment
        //Division assignment
        //Modulus assignment	Right to left

        double doubleValue1 = 20d;
        double doubleValue2 = 80d;
        double doubleResult = 100d * (doubleValue1 + doubleValue2);
        double doubleRemainder = doubleResult % 40d;
        System.out.println(doubleRemainder);
        boolean boolValue = true;
        System.out.println(boolValue);
        // boolValue = (boolean) doubleRemainder;
        if (doubleRemainder == 0){
            System.out.println("The result of the remainder is: " + doubleRemainder);
        }

        System.out.println(doubleResult);
        System.out.println(doubleRemainder);
        boolean checkResult = (doubleRemainder == 0) ? true : false;
        System.out.println(checkResult);
        if (checkResult){
            System.out.println(checkResult + "That was not a remainder");
        }


    }
}
