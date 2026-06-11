package mementoDesignPattern;

class TextEditorTraditional {
    private String text;

    public TextEditorTraditional(String text){
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    public void undo(String previousState){
        this.text = previousState;
    }

    public void showText(){
        System.out.println("Current text: " + text);
    }
}

public class WithoutMementoDP {
    public static void main(String[] args) {
        TextEditorTraditional editor = new TextEditorTraditional("Hello");
        editor.showText();

        String backup = "Hello";
        editor.setText("World");
        editor.showText();

        editor.undo(backup);
        editor.showText();
    }
}
