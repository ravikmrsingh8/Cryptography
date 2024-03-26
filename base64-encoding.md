# Base64 Encoding

## What is Base64 Encoding
Base64 is a binary-to-text encoding scheme. It represents binary data in a printable ASCII string format by translating it into a radix-64 representation.

Base64 encoding is commonly used when there is a need to transmit binary data over media that do not correctly handle binary data and is designed to deal with textual data belonging to the 7-bit US-ASCII charset only.

Base64 encoding encodes any binary data or non-ASCII text data to printable ASCII format so that it can be safely transmitted over any communication channel. 
For example, when you send an email containing an image to your friend, your email software Base64 encodes the image and inserts the equivalent text into the message like so -

```
ontent-Disposition: inline;
	filename=favicon-16x16.png
Content-Transfer-Encoding: base64

iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAARdQTFRFAAAAAAAAAAAAAAAAAQEBDAwMHBwcHx8fCwsLAwMDGRkZHh4eBAQEICAgtra2vb29pKSksLCwODg4FBQUh4eHtLS0m5ubISEh3NzciIiIERERwsLCnp6eAgICjIyMwMDAJycnDg4OBQUFEBAQ0NDQe3t7ycnJeXl5KCgo3d3daWlpCQkJDw8PzMzMmpqarKysyMjIOjo6kZGR9/f3sbGxnZ2dPDw8z8/Pfn5+FxcXjo6OsrKybm5u5ubmExMTBgYG1NTUiYmJCgoKTk5O39/fbGxs7OzsVFRUGhoa2tra9PT00dHRMTExzs7OhoaGhYWFLCwsIyMjuLi4xcXFUlJSRUVFvr6+2dnZoaGhFhYWBwcHFRUV////p5PkYgAAAAN0Uk5Tnvn4e+Nx/gAAAAFiS0dEXOrYAJcAAAAJcEhZcwAAAEgAAABIAEbJaz4AAACnSURBVBjTY2BgZEYCjAwMTMwogImBGQ0ABVhY2dg5gExOLm4esAAvH7+AoBCzsIiomDhYgEtCUkpaRlZOXkFRCSygrKIqrqauoamlqA0xQ0dXT9/A0MjYxNQMIqBsbmFpZW1ja2hnDxGwc3B0cnZxdXNnZmEBC3h4esmJefv4uvj5B4AFAoP0zINDmEPDwiMiwQJR0UrROkDFHNFREDPQnI7hOXTvAwCtbBUc7QjTawAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAxOS0wMS0yMFQwNjo1NTozNiswMDowMA0Ih5IAAAAldEVYdGRhdGU6bW9kaWZ5ADIwMTktMDEtMjBUMDY6NTU6MzYrMDA6MDB8VT8uAAAARnRFWHRzb2Z0d2FyZQBJbWFnZU1hZ2ljayA2LjcuOC05IDIwMTQtMDUtMTIgUTE2IGh0dHA6Ly93d3cuaW1hZ2VtYWdpY2sub3Jn3IbtAAAAABh0RVh0VGh1bWI6OkRvY3VtZW50OjpQYWdlcwAxp/+7LwAAABh0RVh0VGh1bWI6OkltYWdlOjpoZWlnaHQAMTkyDwByhQAAABd0RVh0VGh1bWI6OkltYWdlOjpXaWR0aAAxOTLTrCEIAAAAGXRFWHRUaHVtYjo6TWltZXR5cGUAaW1hZ2UvcG5nP7JWTgAAABd0RVh0VGh1bWI6Ok1UaW1lADE1NDc5NjczMzaP/6esAAAAD3RFWHRUaHVtYjo6U2l6ZQAwQkKUoj7sAAAAVnRFWHRUaHVtYjo6VVJJAGZpbGU6Ly8vbW50bG9nL2Zhdmljb25zLzIwMTktMDEtMjAvMTVjOGNmYTk5NjBmYmJjOWUyY2NjNGI4MTY2YTI3NTQuaWNvLnBuZ0jyrXwAAAAASUVORK5CYII=
```
The friend’s email software will Base64-decode the above encoded textual data to restore the original binary image.

## How does Base64 Encoding work?
> Base 64 encoding described in [RFC 4648](https://datatracker.ietf.org/doc/html/rfc4648)

Base64 encoding works with a 65-character subset of the US-ASCII charset. 
The first 64 characters out of the 65-character subset are mapped to an equivalent 6-bit binary sequence (26 = 64). The extra 65th character (=) is used for padding.

Each of the 6-bit binary sequences from 0 to 63 are assigned a Base64 alphabet. This mapping between the 6-bit binary sequence and the corresponding Base64 alphabet is used during the encoding process. Following is the mapping table which is also called the Base64 index or alphabet table -

```
# The Base64 Alphabet

Value Encoding  Value Encoding  Value Encoding  Value Encoding
    0 A            17 R            34 i            51 z
    1 B            18 S            35 j            52 0
    2 C            19 T            36 k            53 1
    3 D            20 U            37 l            54 2
    4 E            21 V            38 m            55 3
    5 F            22 W            39 n            56 4
    6 G            23 X            40 o            57 5
    7 H            24 Y            41 p            58 6
    8 I            25 Z            42 q            59 7
    9 J            26 a            43 r            60 8
   10 K            27 b            44 s            61 9
   11 L            28 c            45 t            62 +
   12 M            29 d            46 u            63 /
   13 N            30 e            47 v
   14 O            31 f            48 w         (pad) =
   15 P            32 g            49 x
   16 Q            33 h            50 y
```

The Base64 encoding algorithm receives an input stream of 8-bit bytes. It processes the input from left to right and organizes the input into 24-bit groups by concatenating three 8-bit bytes. These 24-bit groups are then treated as 4 concatenated 6-bit groups. Finally, each 6-bit group is converted to a single character in the Base64 alphabet by consulting the above Base64 alphabet table.

When the input has fewer than 24 bits at the end, zero bits are added (on the right) <b>to form an integral number of 6-bit groups.</b> Then, one or two pad (=) characters are output depending on the following cases -

1. **The last chunk of input contains exactly 8 bits**: Four zero bits are added to form two 6-bit groups. Each 6-bit group is converted to the resulting Base64 encoded character using the Base64 index table. After that two pad (=) characters are appended to the output.

2. **The last chunk of input contains exactly 16 bits**: Two zero bits are added to form three 6-bit groups. Each of the three 6-bit groups is converted to the corresponding Base64 alphabet. Finally a single pad (=) character is appended to the output.

Let’s see an example to understand the Base64 encoding process:

Input: ab@yz

Binary Representation (8-bit sequences):

01100001 01100010 01000000 01111001 01111010

**Step 1:** Organize the input into 24-bit groups (having four 6-bit groups each). Pad with zero bits at the end to form an integral no of 6-bit groups.

011000 010110 001001 000000 011110 010111 101000 # (padded with two zeros at the end)

**Step 2:** Convert the 6-bit sequences to Base64 alphabets by indexing into the Base64 index table. Add pad character if zero bits are added at the end of the input.

The above 6-bit groups equate to the following indexes:<code>24 22 9 0 30 23 40</code>.
Indexing into the Base64 alphabet table gives the following output: <code>YWJAeXo=</code>


### Base64 Encoding with URL and Filename safe alphabets
RFC 4648 describes a Base64 encoding variant which is URL and Filename Safe. That means, the output produced by this Base64 encoding variant can be safely transmitted in URLs and used in filenames.

This variant has a simple change to the Base64 alphabet. Since + and / characters have special meaning within URLs and filenames, they are replaced with hyphen (-) and underscore (_)

```
# The "URL and Filename safe" Base 64 Alphabet

Value Encoding  Value Encoding  Value Encoding  Value Encoding
    0 A            17 R            34 i            51 z
    1 B            18 S            35 j            52 0
    2 C            19 T            36 k            53 1
    3 D            20 U            37 l            54 2
    4 E            21 V            38 m            55 3
    5 F            22 W            39 n            56 4
    6 G            23 X            40 o            57 5
    7 H            24 Y            41 p            58 6
    8 I            25 Z            42 q            59 7
    9 J            26 a            43 r            60 8
   10 K            27 b            44 s            61 9
   11 L            28 c            45 t            62 - (hyphen)
   12 M            29 d            46 u            63 _ (underscore)
   13 N            30 e            47 v
   14 O            31 f            48 w         (pad) =
   15 P            32 g            49 x
   16 Q            33 h            50 y
```
[Hands On Examples] Base64Encoding 