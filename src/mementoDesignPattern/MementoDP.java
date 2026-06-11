package mementoDesignPattern;

import java.util.Stack;

class Memento{
    private final String text;

    public Memento(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}

class TextEditor{
    private String text;

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public Memento save(){
        return new Memento(text);
    }

    public void restore(Memento memento){
        this.text = memento.getText();
    }
}

class EditorHistory {
    private Stack<Memento> history = new Stack<>();

    public void push(Memento memento){
        history.push(memento);
    }

    public Memento pop(){
        if(history.isEmpty()){
            return null;
        }
        return history.pop();
    }
}

public class MementoDP {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory editorHistory = new EditorHistory();

        editor.setText("Hello");
        System.out.println("Current text: " + editor.getText());
        editorHistory.push(editor.save());

        editor.setText("World");
        System.out.println("Current text: " + editor.getText());
        editorHistory.push(editor.save());

        editor.setText("Welcome");
        System.out.println("Current text: " + editor.getText());
        editorHistory.push(editor.save());

        editor.setText("Thank you!!");
        System.out.println("Current text: " + editor.getText());

        editor.restore(editorHistory.pop());
        System.out.println("After undo text: " + editor.getText());

        editor.restore(editorHistory.pop());
        System.out.println("After second undo text: " + editor.getText());
    }
}
