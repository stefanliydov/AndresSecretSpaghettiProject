package quiz;

import quiz.question.AlwaysTrueQuestion;
import quiz.question.BSQuestion;
import quiz.question.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelCreator {

    private Map<Integer, List<Question>> roundQuestions;

    public LevelCreator() {
        this.generateQuestionMap();
    }

    public List<Question> getRoundQuestions(int i) {
        return roundQuestions.get(i);
    }

    private void generateQuestionMap() {
        roundQuestions = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            roundQuestions.put(i, this.loadRoundQuestions(i));

        }

    }

    private List<Question> loadRoundQuestions(int i) {
        List<Question> questions = new ArrayList<>();
        fetchRoundQuestions(i, questions);
        return questions;

    }

    private void fetchRoundQuestions(int i, List<Question> questions) {
        switch (i) {
            case 1:
                questions.add(new Question("Continue the saying \"On every meal.. \""
                        , "Plamena", new String[]{"Salt", "Spoon", "Merodia"}));
                questions.add(new Question("What is the most popular Internet Service Provider (ISP) in the village of Mogila?",
                        "Pigeon Fiber Optics", new String[]{"Net1 Wireless", "Vivacom Cable", "Internet Group Ltd"}));
                questions.add(new Question("Stefan - The well known villager with Greek roots, used to sport which famous hairstyle?",
                        "The Palm tree", new String[]{"The Mohawk", "The Mullet", "The Manbun"}));
                questions.add(new Question("According to the old testament of the Bible, God has?",
                        "Serious anger management issues", new String[]{"A son named Jesus", "Long white beard", "A donkey"}));
                questions.add(new Question("Finish the story - \"A kid walks in to a store...\"",
                        "and buys vouchers for 100lv", new String[]{"buys groceries and leaves the store",
                        "and start singing - \"Nai-obicham ludi-ludi jabi\"", "Ketchup"}));
                break;
            case 2:
                questions.add(new Question("The concert debut of the Violin, Piano and Oboe trio of \"The Boes\" was playing:",
                        "The Song from the Secret Garden", new String[]{"The Song from the Secret Project", "The Song of the Secret Service", "The Song of the Secret Agent"}));
                questions.add(new Question("Bobe's quote obsession was first observed around fifth grade. What was he quoting back then?",
                        "Star Wars", new String[]{"Lord of the Rings", "Batman", "Pirates of the Caribbean"}));
                questions.add(new Question("Finish the line RyanAir - Low fares...?",
                        "made simple", new String[]{"with micro transactions", "don't exist", "shit customer service"}));
                questions.add(new Question("What was the first line Andres ever wrote to Stefan?",
                        "\"Akah\"", new String[]{"\"zdr\"" , "\"ni6to\"", "\"Az sym andrei\""}));
                questions.add(new Question("The RMS Titanic was pulled over by KAT for speeding just hours before the incident. What was the alleged speed at which it was going?",
                        "200 km/h", new String[]{"42 km/h", "21 knots", "74 km/h"}));

                break;
            case 3:
                questions.add(new Question("Which of the following used to be Bobe's later school years quick meal choice?",
                        "Milk and Everest biscuits", new String[]{"Seven days and Borovets waffle", "Hotdog with kebabche", "Pickles"}));
                questions.add(new Question("Which of the following used to be Bobe's early school days quick meal choice?",
                        "Seven days and Borovets waffle", new String[]{"Broccoli with cream", "Pizza slice", "Milk and Everest biscuits"}));
                questions.add(new Question("In the early days a food tradition was established for the Solfej classes. What was the meal?",
                        "Pizza", new String[]{"Tosters", "HotDog", "Chips"}));
                questions.add(new Question("Andres is famous for which of his survival techniques?",
                        "Shortcuts", new String[]{"Amazing camera work", "Sounding really gay on the videos", "Amazing cartographer skills"}));
                break;
            case 4:
                questions.add(new Question("According to our survey of two people what was the weirdest food Andres ate at school ever? ",
                        "Jar of pickles", new String[]{"Carrots", "Lemons", "Taralli"}));
                questions.add(new Question("The world wide multimedia giant InGen Company Inc. started out as a single branch being...?",
                        "Video Creation", new String[]{"Book Publishing", "Music Production", "Video Translation"}));
                questions.add(new Question("What follows after the famous quote: \"Helloooo Stonehenge...\"?",
                        "Who takes the Pandorica", new String[]{"Who takes the TARDIS", "Who takes the Pandora", "Who takes Gallifrey"}));
                questions.add(new Question("\"Helloooo Stonehenge...\" is a famous quote by which doctor?",
                        "Matt Smith", new String[]{"Peter Capaldi", "David Tennant", "Tom Baker"}));
                questions.add(new Question("What is Stefan's most terrifying experience?",
                        "Andres giving him a surprising face slap", new String[]{"Talking to girls", "Talking to someone", "Talking..."},false));
                questions.add(new Question("In the summer of 2010 The Enviromentalist Party proposed what kind of Eco Friendly Product?",
                        "Recycled paper benches", new String[]{"Car fume filter", "Ganja vape", "Recycled plastic roads"}));
                break;
            case 5:
                questions.add(new Question("\"I want to know what happened to the plans they sent you!\" as Bobe used to repeat, is a quote of which character?",
                        "Darth Vader", new String[]{"General Grievous", "The Doctor", "Count Dooku"}));
                questions.add(new Question("Finish the song - Its Georgita ! She comes ... ",
                        "to take the room!", new String[]{"to clean the house!", "to fix the plumbing!", "to sell you drugs!"}));
                questions.add(new Question("Which one of these was the first multi-song mix we played.?",
                        "Tango le mio", new String[]{"Pachel-hallelujah", "Hello Caruso", "Viva la'll of me"}));
                questions.add(new Question("According to our survey of two, which andres made dish should be on the cover of \"Exquisite Cuisine\"?",
                        "Barbequed biscuits", new String[]{"HardRock Fan TM. pancakes", "Tomato toaster", "Quinoa with four types of cheese and plastic"}));
                break;
            case 6:
                questions.add(new Question("The famous \"Violin Room\", where the renown Tritone Music Duo used to practice, is number... ?",
                        "41", new String[]{"44", "42", "31"}));
                questions.add(new Question("The hostess of the Dormitories in Sofia - Tsetska Krasteva, used which famous wrestler's entrance theme?",
                        "Stone Cold Steve Austin", new String[]{"The Rock", "Triple H", "The Undertaker"}));
                questions.add(new Question("Why did Bobe abandon the Jack Sparrow impressions?",
                        "He looked gay whenever he moved", new String[]{"He lost the voice", "He got bored", "He moved on"}));
                questions.add(new Question("What does Andres remember the first \"Lord Of The Rings in concert\" for?",
                        "The failed puzzle solving attempt", new String[]{"Brilliant performance", "The loud audience", "Gollum!!"}));
                break;
            case 7:
                questions.add(new Question("In 2013, Grandmaster Garry Kasparov defeated his opponent using?",
                        "a very dubious move", new String[]{"a brilliant double rook sacrifice", "the eight pawn gambit", "a double bishop sacrifice"}));
                questions.add(new Question("What is the only crisis in China that you know of?",
                        "Kriza na oriza", new String[]{"The Ming Dynasty crisis 1531", "The population crisis of 1966", "Can it run Crysis 2007?"}));
                questions.add(new Question("The longest standing mascot of the Sofia Dormitory is?",
                        "The Zagorka bottle", new String[]{"The toilet paper tower", "The \"Nature morte\" (Fr.) ", "The Coconut"}));
                break;
            case 8:
                questions.add(new Question("Andres is known for his enormous... ;)?",
                        "Dick", new String[]{"Talent", "Charisma", "Smile"}));
                questions.add(new Question("Andres is known for his enormous...?",
                        "Talent", new String[]{"Dick", "Appetite", "Feet"}));
                break;
            case 9:
                questions.add(new Question("During his five years of obligatory piano, how many exams did Bobe attend?",
                        "2", new String[]{"0", "1", "6"}));
                questions.add(new Question("Bobe's most frequently used Jack Sparrow quote is?",
                        "Oh Buggah", new String[]{"I'm Captain Jack Sparrow!", "Why is the rum gone?", "Rum's good!"}));
                break;
            case 10:
                questions.add(new Question("The first concept of the \"Tritone\" brand name came up on which project?",
                        "Drag ropes ", new String[]{"Africa", "Doctor Who cover", "Cyber planet"}));
                questions.add(new Question("Bobe does not approve of the first \"Tritone\" single \"Africa\" because...?",
                        "He played it as a joke", new String[]{"It sounds too much like Zoo tycoon",
                        "Of the kaval solo", "He's a perfectionist."}));

                break;
            case 11:
                questions.add(new Question("What tragic event happened in the life of Bobe on the 17th of february, 2012?",
                        "Oxygen# server shuts down", new String[]{"A bucket filled with cold water was dropped on his head",
                        "He was denied a date by Alexandrina", "The great separation between Andres and Bobe"}));
                /*questions.add(new Question("",
                        "", new String[]{"", "", ""}));
                questions.add(new Question("",
                        "", new String[]{"", "", ""}));*/
                break;
            case 12:
                questions.add(new AlwaysTrueQuestion("What was the license plate number of Bobe's previous car - \"The Golf\"?",
                        "CT 1521 AP", new String[]{"CT 9612 AM", "CT 6721 AH", "CT 4015 CB"}));
                break;
            default:
                break;
        }

    }


}
