import tkinter as tk
import nltk

# Load the NLTK English words corpus
nltk.download('words')
from nltk.corpus import words

class Notepad(tk.Tk):
    def __init__(self):
        super().__init__()

        # Create the text area
        self.text = tk.Text(self)
        self.text.pack(expand=True, fill=tk.BOTH)

        # Create the auto-suggestion widget
        self.suggestion_box = tk.Listbox(self)
        self.suggestion_box.pack(side=tk.TOP, fill=tk.X)

        # Create the auto-suggestion function
        self.auto_suggestion = tk.StringVar()
        self.suggestions = words.words()
        self.auto_suggestion.trace("w", self.suggest_words)

        # Create the bindings for the text area
        self.text.bind("<KeyRelease>", self.on_key_release)

    def suggest_words(self, *args):
        # Get the current text in the text area
        text = self.text.get("1.0", tk.END)

        # Split the text into words
        words = text.split()

        # Get the last word in the text
        last_word = words[-1] if words else ""

        # Get the suggestions for the last word
        suggestions = [word for word in self.suggestions if word.startswith(last_word)]

        # Update the auto-suggestion variable with the suggestions
        self.auto_suggestion.set(" ".join(suggestions))

        # Update the suggestion box
        self.suggestion_box.delete(0, tk.END)
        self.suggestion_box.insert(tk.END, *suggestions)

    def on_key_release(self, event):
        # If the user presses the Enter key, insert the selected suggestion
        if event.keysym == "Return":
            selection = self.suggestion_box.curselection()
            if selection:
                index = selection[0]
                suggestion = self.suggestion_box.get(index)
                self.text.insert(tk.END, suggestion + " ")
                self.text.mark_set(tk.INSERT, "end-1c")
                self.suggestion_box.delete(0, tk.END)

if __name__ == "__main__":
    app = Notepad()
    app.mainloop()