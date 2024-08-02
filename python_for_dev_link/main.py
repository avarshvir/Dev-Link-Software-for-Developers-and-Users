import tkinter as tk

# Create the main window
root = tk.Tk()
root.title("Hello, Tkinter!")

# Add widgets (components) to the main window
label = tk.Label(root, text="Welcome to Tkinter!")
label.pack()

button = tk.Button(root, text="Click Me!")
button.pack()

# Run the application
root.mainloop()
