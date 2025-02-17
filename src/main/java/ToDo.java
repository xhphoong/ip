package anya;

/**
 * Represents a todo task with task description.
 */
class ToDo extends Task {

    ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String write() {
        return "T" + super.write() + ":X";
    }

}
