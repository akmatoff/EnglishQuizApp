package com.coorootinc.englishquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME  = "QuizApp.db";
    private static final int DATABASE_VERSION = 8;

    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable() {
        Question q1 = new Question("What do we call a physical part of a computer?", "software", "malware", "hardware", "spyware", 3);
        addQuestion(q1);
        Question q2 = new Question("What does HTML stand for?", "HyperText Markup Language", "HyperText Makeup Language", "HyperText Machine Language", "HyperText Main Language", 1);
        addQuestion(q2);
        Question q3 = new Question("Which of those below is not a physical part of a computer?", "case", "hard disk drive", "RAM", "Operation System", 4);
        addQuestion(q3);
        Question q4 = new Question("What is GPS?", "Global Working System", "Global Positioning System", "Location", "Global Positioning Standart", 2);
        addQuestion(q4);
        Question q5 = new Question("How to say\"Айтишник\" in English?", "IT-shnik", "Tech", "Fixick", "Technician", 4);
        addQuestion(q5);
        Question q6 = new Question("How many bits make a byte?", "16", "6", "8", "32", 3);
        addQuestion(q6);
        Question q7 = new Question("What is the meaning of CPU?", "Central Processing Unit", "Critical Processing Unit", "Crucial Processing Unit", "Central Printing Unit", 1);
        addQuestion(q7);
        Question q8 = new Question("Which of the items is an input device?", "Monitor", "Keyboard", "Speakers", "Projector", 2);
        addQuestion(q8);
        Question q9 = new Question("What does SaaS stand for?", "Software as a Server", "Software as a Screen", "Software as a Service", "Software as a Style", 3);
        addQuestion(q9);
        Question q10 = new Question("What do we call a programming language?", "Code", "CPU", "Compiler", "Statement", 1);
        addQuestion(q10);
        Question q11 = new Question("An acronym for a system of tagging products?", "RSID", "EPOS", "RFID", "LBS", 3);
        addQuestion(q11);
        Question q12 = new Question("To put something on to a system such as the internet.", "Upgrade", "Download", "Load", "Upload", 4);
        addQuestion(q12);
        Question q13 = new Question("A document that accompanies an email.", "Application", "Attachment", "Warehouse", "Link", 2);
        addQuestion(q13);
        Question q14 = new Question("An acronym for a type of electronic till.", "SPOS", "EPOS", "EPES", "CPOS", 2);
        addQuestion(q14);
        Question q15 = new Question("What does LBS stand for?", "Location-Based Services", "Location-Based Servers", "Location-Based Styles", "Location-Based Streams", 1);
        addQuestion(q15);
        Question q16 = new Question("What does LAN stand for?", "Local Annoying Network", "Logic Area Network", "Local Area Nut", "Local Area Network", 4);
        addQuestion(q16);
        Question q17 = new Question("What is PDA?", "A laptop", "A handheld device", "A desktop computer", "Supercomputer", 2);
        addQuestion(q17);
        Question q18 = new Question("Which of these is about Data Processing?", "Testing hardware", "Updating security software", "Writing code", "Providing technical support", 3);
        addQuestion(q18);
        Question q19 = new Question("Which of these is about Information Security?", "Encoding online data transfers", "Organizing Data", "Testing hardware", "Providing technical support", 1);
        addQuestion(q19);
        Question q20 = new Question("Which of these is about Quality Assurance?", "Writing code", "Updating security software", "Organizing Data", "Testing hardware", 4);
        addQuestion(q20);
        Question q21 = new Question("Putting secret information into code", "Coding", "Data processing", "Encoding", "Lying", 3);
        addQuestion(q21);
        Question q22 = new Question("What is Data Processing?", "Putting secret information into code", "Checking products for problems", "The act of protecting information", "The act of using information", 4);
        addQuestion(q22);
        Question q23 = new Question("What do we call the last sentence in a paragraph?", "Topic sentence", "Concluding sentence", "Supporting sentence", "Ending sentence", 2);
        addQuestion(q23);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NUM, question.getAsnwerNum());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION4)));
                question.setAsnwerNum(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NUM)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
