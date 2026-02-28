class CalculGrade {

    static String notation(double mark) {
        if (mark >= 85) return "A";
        if (mark >= 75) return "B";
        if (mark >= 65) return "C";
        if (mark >= 50) return "D";
        return "F";
    }

    static double avg(Stud s) {
        double sum = 0;
        for (Result r : s.results.values()) {
            sum += r.mark;
        }
        return sum / s.results.size();
    }
}