{\rtf1\ansi\ansicpg1252\cocoartf1187\cocoasubrtf400
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural

\f0\fs24 \cf0 class Solution \{\
public:\
    string minWindow(string S, string T) \{\
        if (T.size() > S.size()) \{\
            return ""; \
        \}\
        \
        map<char, int> needToFind;  // Letters a window must have\
        map<char, int> hasFound;   // Letters a window already have\
        int count = 0;  // Number of letters we need to find in the window\
        int min = INT_MAX;  // Length of minimum window \
        string minWindow = ""; // Minimum window \
        \
        // Build needToFind table \
        for (int i = 0; i < T.size(); i++) \{\
            char c = T[i];\
            if (needToFind.find(c) == needToFind.end()) \{\
                needToFind[c] = 1; \
            \}\
            else \{\
                needToFind[c]++; \
            \}\
        \}\
        \
        // Build hasFound table \
        for (int i = 0; i < S.size(); i++) \{\
            char c = S[i]; \
            \
            hasFound[c] = 0; \
        \}\
        \
        // Searching for min window\
        int begin = 0; \
        int end = 0; \
        \
        while (end < S.size()) \{\
            char endChar = S[end]; \
            \
            if (needToFind.find(endChar) != needToFind.end() && hasFound[endChar] < needToFind[endChar]) \{\
                count++; \
            \} \
            \
            hasFound[endChar]++; \
            \
            if (count == T.size()) \{  // Find a window \
                char beginChar = S[begin]; \
                \
                // Try to move left end \
                while (needToFind.find(beginChar) == needToFind.end() || needToFind[beginChar] < hasFound[beginChar]) \{\
                    hasFound[beginChar]--; \
                    begin++; \
                    beginChar = S[begin]; \
                \}\
                \
                // Update min window \
                if (end - begin + 1 < min) \{\
                    min = end - begin + 1; \
                    minWindow = S.substr(begin, min); \
                \}\
            \}\
            \
            end++; \
        \}\
        \
        return minWindow; \
    \}\
\};}