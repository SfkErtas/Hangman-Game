import java.util.Scanner;

class Game {
    private static final String[] WORDS = {"mercedes", "ferrari", "redbull", "mclaren", "williams"};
    private static final int MAX_GUESSES = 4;

    private static String getRandomWord()
    {
        int randomIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomIndex];
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getRandomWord();
        StringBuilder guessedWord = new StringBuilder(wordToGuess.length());
        int wrongGuesses = 0;
        boolean gameWon = false;

        for (int i = 0; i < wordToGuess.length(); i++)
        {
            guessedWord.append("_");
        }

        System.out.println("You have " + MAX_GUESSES + " incorrect guesses before you lose.");

        while (wrongGuesses < MAX_GUESSES && !gameWon)
        {
            System.out.println("\nWord: " + guessedWord.toString());
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);
            boolean found = false;
            boolean alreadyGuessed = false;

            for (int i = 0; i < wordToGuess.length(); i++)
            {
                if (wordToGuess.charAt(i) == guess)
                {
                    if (guessedWord.charAt(i) == guess)
                    {
                        alreadyGuessed = true;
                        break;
                    }
                    guessedWord.setCharAt(i, guess);
                    found = true;
                }
            }

            if (alreadyGuessed)
            {
                System.out.println("You already guessed that letter. Try again.");
            }
            else if (found)
            {
                if (guessedWord.toString().equals(wordToGuess))
                {
                    gameWon = true;
                }
            }
            else
            {
                wrongGuesses++;
                System.out.println("Incorrect guess. You have " + (MAX_GUESSES - wrongGuesses) + " incorrect guesses left.");
            }
        }

        if (gameWon)
        {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        }
        else
        {
            System.out.println("Game over! The word was: " + wordToGuess);
        }
    }
}