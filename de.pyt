# Open the file in read mode
file = open("input.txt", "r")

# Read the contents of the file
text = file.read()

# Close the file
file.close()

# Count how many times the word “dictum” appears in the file
dictum_count = text.count("dictum")

# Determine how many words there are in the text
words = text.split()
word_count = len(words)

# Determine how many words have the letter e in it
e_count = sum(1 for word in words if 'e' in word.lower())

# Determine the length of the longest word in it
longest_word_length = max(len(word) for word in words)

# Create a new file call it output_1.txt, where all of the occurrences of the word “dictum” changes into upper case.
output_1 = text.replace("dictum", "DICTUM")

question 2
# Open the file in write mode
file = open("output_1.txt", "w")

# Write the modified text to the file
file.write(output_1)

# Close the file
file.close()

# Create a new file call it output_2.txt where all letters changes to uppercase
output_2 = text.upper()

# Open the file in write mode
file = open("output_2.txt", "w")

# Write the modified text to the file
file.write(output_2)

# Close the file
file.close()