interface UserPermission {
    void borrowBook(int bookId, BookManagement bookManager);
    void returnBook(int bookId, BookManagement bookManager);
}