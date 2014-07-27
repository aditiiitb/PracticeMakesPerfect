using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using GalaSoft.MvvmLight;
using Prototype2.Models;

namespace Prototype2.ViewModel
{
    public class QuestionPageViewModel:ViewModelBase
    {
        private Question _question;

        public Question Question
        {
            get { return _question; }
            set
            {
                value = _question;
                RaisePropertyChanged();
            }
        }

        public QuestionPageViewModel()
        {
            Question = new Question
            {
                Text = "Which series does this actor star in ?",
                ImageSource = "http://www.bbcamerica.com/anglophenia/files/2013/06/sherlock.jpg"
            };
        }
    }
}
