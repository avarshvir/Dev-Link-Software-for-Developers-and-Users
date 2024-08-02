import tkinter as tk
from tkinter import filedialog
import re

class HTMLEditor(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("HTML Editor")
        self.geometry("800x600")

        self.text_area = tk.Text(self, font=("Courier", 12), bg="grey", fg="black")  # Set background to black and foreground to white
        self.text_area.pack(expand=True, fill="both")

        self.tag_colors = self.load_tag_colors("tags.txt")

        self.text_area.bind("<KeyRelease>", self.highlight_tags)

        menu_bar = tk.Menu(self)
        file_menu = tk.Menu(menu_bar, tearoff=0)
        file_menu.add_command(label="Open", command=self.open_file)
        file_menu.add_command(label="Save", command=self.save_file)
        file_menu.add_separator()
        file_menu.add_command(label="Exit", command=self.quit)
        menu_bar.add_cascade(label="File", menu=file_menu)
        self.config(menu=menu_bar)

    def load_tag_colors(self, file_path):
        tag_colors = {}
        with open(file_path, "r") as file:
            for line in file:
                tag, color = line.strip().split(",")
                tag_colors[tag] = color
        return tag_colors

    def highlight_tags(self, event=None):
        content = self.text_area.get("1.0", "end")
        self.text_area.tag_remove("tag", "1.0", "end")  # Remove all existing tags

        for tag, color in self.tag_colors.items():
            start = "1.0"
            opening_tag = tag
            closing_tag = f"</{tag[1:]}"  # Generate the closing tag
            tag_name = f"{tag}_{color}"

            while True:
                start = self.text_area.search(tag, start, stopindex="end", regexp=True)
                if not start:
                    break
                end = f"{start}+{len(tag)}c"
                self.text_area.tag_add(tag_name, start, end)
                self.text_area.tag_config(tag_name, foreground=color)
                start = end

        self.highlight_text()

    def highlight_text(self):
        content = self.text_area.get("1.0", "end")
        pattern = r'".*?"'
        start = "1.0"
        while True:
            start = self.text_area.search(pattern, start, stopindex="end", regexp=True)
            if not start:
                break
            end = f"{start}+{len(re.search(pattern, content[start:]).group())}c"
            self.text_area.tag_add("text", start, end)
            self.text_area.tag_config("text", foreground="green")
            start = end

    def open_file(self):
        initial_dir = "E:\\universityproject\\userfiles"
        file_path = filedialog.askopenfilename(defaultextension=".html", initialdir=initial_dir)
        if file_path:
            with open(file_path, "r") as file:
                content = file.read()
                self.text_area.delete("1.0", "end")
                self.text_area.insert("end", content)
                self.highlight_tags()

    def save_file(self):
        initial_dir = "E:\\universityproject\\userfiles"
        file_path = filedialog.asksaveasfilename(defaultextension=".html", initialdir=initial_dir)
        if file_path:
            with open(file_path, "w") as file:
                content = self.text_area.get("1.0", "end")
                file.write(content)

if __name__ == "__main__":
    editor = HTMLEditor()
    editor.mainloop()