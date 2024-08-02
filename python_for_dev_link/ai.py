import tkinter as tk
import win32com.client
import speech_recognition as sr
import random

def set_voice_by_name(speaker, voice_name):
    voices = speaker.GetVoices()
    for voice in voices:
        if voice.GetDescription() == voice_name:
            speaker.Voice = voice
            break

def speak_text(text):
    speaker.Speak(text)

def recognize_speech():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        audio = r.listen(source)
        try:
            text = r.recognize_google(audio)
            if text.lower() == "hello":
                text_entry.delete(0, tk.END)  # Clear the text entry
                text_entry.insert(tk.END, "hi")
                speak_text("hi")
                speak_button.config(state=tk.DISABLED)  # Disable the speak button after saying hello
        except sr.UnknownValueError:
            print("Could not recognize speech")
        except sr.RequestError as e:
            print("Could not request results from Google Speech Recognition service; {0}".format(e))

def on_text_change(event):
    text = text_entry.get()
    if text.lower() == "hello":
        text_entry.delete(0, tk.END)  # Clear the text entry
        text_entry.insert(tk.END, "hi")
        speak_text("hi")
        speak_button.config(state=tk.DISABLED)  # Disable the speak button after typing hello

# Define the GUI window
window = tk.Tk()
window.geometry("300x300")
window.title("AI by DevLink")

# Create a text entry field
text_entry = tk.Entry(window)
text_entry.pack(pady=10)
text_entry.bind("<KeyRelease>", on_text_change)

# Create a button to trigger the speech
speaker = win32com.client.Dispatch("SAPI.SpVoice")
set_voice_by_name(speaker, "Microsoft David Desktop - English (United States)")
speak_button = tk.Button(window, text="Speak", command=lambda: speak_text(text_entry.get()))
speak_button.pack(pady=10)

# Create a button to trigger the speech recognition
recognize_button = tk.Button(window, text="Listen", command=recognize_speech)
recognize_button.pack(pady=10)

# Run the GUI window
window.mainloop()
