import tkinter as tk
from tkinter import ttk, colorchooser, filedialog


class DrawingApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Simple Drawing App")
        self.root.geometry("800x600")

        self.current_color = "black"
        self.brush_size = 2
        self.selected_tool = "pencil"
        self.start_x = None
        self.start_y = None
        self.shapes = []

        self.canvas = tk.Canvas(self.root, bg="white")
        self.canvas.pack(fill=tk.BOTH, expand=True)

        self.toolbar = ttk.Frame(self.root)
        self.toolbar.pack(side=tk.TOP, fill=tk.X)

        color_button = ttk.Button(self.toolbar, text="Color", command=self.choose_color)
        color_button.grid(row=0, column=0, padx=5, pady=5)

        brush_size_label = ttk.Label(self.toolbar, text="Brush Size:")
        brush_size_label.grid(row=0, column=1, padx=5, pady=5)

        self.brush_size_scale = ttk.Scale(self.toolbar, from_=1, to=10, orient=tk.HORIZONTAL, command=self.change_brush_size)
        self.brush_size_scale.set(2)
        self.brush_size_scale.grid(row=0, column=2, padx=5, pady=5)

        tools_label = ttk.Label(self.toolbar, text="Tools:")
        tools_label.grid(row=0, column=3, padx=5, pady=5)

        self.tools_combo = ttk.Combobox(self.toolbar, values=["pencil", "eraser", "rectangle", "oval"], state="readonly")
        self.tools_combo.current(0)
        self.tools_combo.grid(row=0, column=4, padx=5, pady=5)
        self.tools_combo.bind("<<ComboboxSelected>>", self.change_tool)

        save_button = ttk.Button(self.toolbar, text="Save", command=self.save_drawing)
        save_button.grid(row=0, column=5, padx=5, pady=5)

        self.canvas.bind("<Button-1>", self.start_draw)
        self.canvas.bind("<B1-Motion>", self.draw)
        self.canvas.bind("<ButtonRelease-1>", self.stop_draw)

    def choose_color(self):
        color = colorchooser.askcolor()[1]
        if color:
            self.current_color = color

    def change_brush_size(self, size):
        self.brush_size = int(size)

    def change_tool(self, event):
        self.selected_tool = self.tools_combo.get()

    def start_draw(self, event):
        self.start_x = event.x
        self.start_y = event.y
        if self.selected_tool == "rectangle" or self.selected_tool == "oval":
            self.shapes.append((self.start_x, self.start_y))

    def draw(self, event):
        if self.selected_tool == "pencil":
            self.canvas.create_line(self.start_x, self.start_y, event.x, event.y, fill=self.current_color, width=self.brush_size)
            self.start_x = event.x
            self.start_y = event.y
        elif self.selected_tool == "eraser":
            self.canvas.create_rectangle(event.x - self.brush_size, event.y - self.brush_size,
                                         event.x + self.brush_size, event.y + self.brush_size, fill="white", outline="")
        elif self.selected_tool == "rectangle":
            self.canvas.delete("temp_shape")
            self.canvas.create_rectangle(self.shapes[-1][0], self.shapes[-1][1], event.x, event.y, outline=self.current_color, width=self.brush_size, tags="temp_shape")
        elif self.selected_tool == "oval":
            self.canvas.delete("temp_shape")
            self.canvas.create_oval(self.shapes[-1][0], self.shapes[-1][1], event.x, event.y, outline=self.current_color, width=self.brush_size, tags="temp_shape")

    def stop_draw(self, event):
        if self.selected_tool == "rectangle" or self.selected_tool == "oval":
            self.shapes.pop()

    def save_drawing(self):
        filename = filedialog.asksaveasfilename(defaultextension=".png", filetypes=[("PNG files", "*.png"), ("All Files", "*.*")])
        if filename:
            x = self.root.winfo_rootx() + self.canvas.winfo_x()
            y = self.root.winfo_rooty() + self.canvas.winfo_y()
            x1 = x + self.canvas.winfo_width()
            y1 = y + self.canvas.winfo_height()
            self.canvas.postscript(file=filename, colormode='color', x=x, y=y, width=x1, height=y1)


if __name__ == "__main__":
    root = tk.Tk()
    app = DrawingApp(root)
    root.mainloop()
