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
    private static final int DATABASE_VERSION = 6;

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
        Question q1 = new Question("Основу древнего римского народа составляли", "римляне, сабины, эллины", "римляне, греки, этруски ", "римляне, сабины, этруски", "римляне, сабины, славяне", 3);
        addQuestion(q1);
        Question q2 = new Question("Языком римской цивилизации становится", "арабский", "римский", "греческий", "латынь", 4);
        addQuestion(q2);
        Question q3 = new Question("Кого римляне называли «варварами»?", "племена не знающие латинского или греческого языка", "жестоких императоров", "всех, кто проживал вне города", "всех", 1);
        addQuestion(q3);
        Question q4 = new Question("На чем писались древнерусские письма , документы?", "Береста", "Папирус", "Пергамент", "Лыко", 1);
        addQuestion(q4);
        Question q5 = new Question("Как в Древней Руси назывался княжеский престол?", "Стол", "Седалище ", "Держава", "Стуло", 1);
        addQuestion(q5);
        Question q6 = new Question("Начиная с какого времени в Китае начала править династия Тан?", " С начала седьмого века", "С начала шестого века ", "С конца восьмого века ", "С конца седьмого века", 1);
        addQuestion(q6);
        Question q7 = new Question("Какие кочевники начали завование Китая в начале XIII века?", "Скифы", "Тюрки", "Монголы", "Авары ", 3);
        addQuestion(q7);
        Question q8 = new Question("Столица монгольской державы", "Самарканд", "Пекин", "Сарай-Бату", "Каракорум", 3);
        addQuestion(q8);
        Question q9 = new Question("Что было изобретено в средневековом Китае?", "Печатный станок ", "Изготовление фарфора", "Боевая колесница", "Все варианты верны", 2);
        addQuestion(q9);
        Question q10 = new Question("В период какой династии средневековый Китай достиг наибольших размеров?", "Мин", "Тан", "Цинь", "Сун", 2);
        addQuestion(q10);
        Question q11 = new Question("Сколько длились темные века?", "XII - IX", "XI - IX", "XI - X", "XII - X", 2);
        addQuestion(q11);
        Question q12 = new Question("События в 1194 - 1184 до н. э.", "Вторжение на Пелопоннес дорийских племен", "Нет правильного ответа", "Троянская война", "Вторжение на Пелопоннес дорийских племен", 3);
        addQuestion(q12);
        Question q13 = new Question("Поход Дария I против скифов.", "514 г.", "524 г.", "510 г.", "526 г.", 1);
        addQuestion(q13);
        Question q14 = new Question("В каком году открыли олимпийские игры?", "866 г.", "776 г.", "756 г.", "856 г.", 2);
        addQuestion(q14);
        Question q15 = new Question("Правление Дария I в Персии", "522-486 гг.", "552-468 гг.", "520-480 гг.", "523-481 гг.", 1);
        addQuestion(q15);
        Question q16 = new Question("Год формирования афинской морской державы", "Нет правильного ответа", "454 г.", "554 г.", "523 г.", 2);
        addQuestion(q16);
        Question q17 = new Question("Война Спарты с Персией", "389-394 гг.", "400-395 гг.", "399-394 гг.", "390-394 гг.", 3);
        addQuestion(q17);
        Question q18 = new Question("Египетский поход Александра", "330-331 гг.", "Нет правильного ответа", "331-333 гг.", "331-342 гг.", 2);
        addQuestion(q18);
        Question q19 = new Question("Годы жизни философа Сократа", "399-467 гг.", "399-347 гг.", "399-470 гг.", "399-481 гг.", 3);
        addQuestion(q19);
        Question q20 = new Question("Годы жизни философа Платона", "345-425 гг.", "347-427 гг.", "346-426 гг.", "346-430 гг.", 2);
        addQuestion(q20);
        Question q21 = new Question("Определите среди перечисленных город, который не располагался на территории Древнего Египта", "Абидос", "Сидон", "Саис", "Сиена", 2);
        addQuestion(q21);
        Question q22 = new Question("Когда в Римской империи были запрещены Олимпийские игры, посвященные Зевсу и с чем это было связано?", "в IV в. до н.э., с провозглашением Римской республики", "в I в. до н.э.,с восстанием Спартака", "в III в. н.э., с началом распада империи и постоянными войнами", "в IV в. н.э., с утверждением христианской религии в Риме", 4);
        addQuestion(q22);
        Question q23 = new Question("В низовьях каких рек были основаны древнегреческие колонии?", "Тигра, Нила, По", "По, Дона, Нила", "Днепра, Дуная, Евфрата", "Днестра, Днепра, Тигра", 2);
        addQuestion(q23);
        Question q24 = new Question("В каком из государств функционировала так называемая Царская дорога?", "древнем Риме", "Ассирийском", "древнем Египте", "Персидском", 4);
        addQuestion(q24);
        Question q25 = new Question("В каком ответе хронологически правильно указана последовательность событий древней истории?", "изготовление керамики, изобретение лука и стрел", "появление наскальных рисунков, первые захоронения умерших", "домостроительство, захоронение умерших", "первые наскальные рисунки, изобретение лука и стрел", 4);
        addQuestion(q25);
        Question q26 = new Question("Определите основные занятия древних людей, живших 30-14 тыс. лет тому назад.", "охота, собирательство", "охота, собирательство, рыболовство", "собирательство, приручение животных, мотыжное земледелие", "ремесло, земледелие, скотоводство", 2);
        addQuestion(q26);
        Question q27 = new Question("Когда был построен храм бога Луны в городе Уре?", "в XIX в. до н.э.", "в XX в. до н.э.", "в XXI в. до н.э.", "в XVIII в. до н.э", 3);
        addQuestion(q27);
        Question q28 = new Question("Одной из наиболее почитаемых богинь Греции была богиня плодородия Деметра, а у римлян богиней плодородия была ...", "Минерва", "Диана", "Юнона", "Церера", 4);
        addQuestion(q28);
        Question q29 = new Question("Покровителем виноделия в Греции был бог Дионис, о котором говорится, что его всегда сопровождали неизменные спутники сатиры и спутницы ...", "менады", "нимфы", "русалки", "музы", 1);
        addQuestion(q29);
        Question q30 = new Question("Кто из античных скульпторов создал прославленную статую Зевса Олимпийского?", "Поликлет", "Фидий", "Мирон", "Гесиод", 2);
        addQuestion(q30);
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
